package top.dainel.thunder.warning.dbscan;

import java.util.Iterator;
import java.util.List;

/**
 * 线性趋势计算器
 * 经纬度坐标成线性增长
 * 半径坐标增加惰性系数
 */
public class LinearTrend {
    public List<Circle>[] getCenters() {
        return centers;
    }

    public Circle[] getLastCenters() {
        return lastCenters;
    }

    private List<Circle>[] centers;
    private double firstIndex;//第一组数据的时间戳
    private double secIndex;//第二组数据的时间戳
    private Circle[] lastCenters;//第二次中心点的上一次追溯
    private double centerR=0.5;//中心点最远距离 超过该距离则不作为同一雷云处理
    public  double inertia=0.6;//惰性系数0~1~∞ 数值越小 惰性越大 1 惰性为0
    
    /**
     * @param centers 中心点List数组 数组中
     */
	public LinearTrend(List<Circle>[] centers, double firstIndex, double secIndex) {
		this(centers, null, null, firstIndex, secIndex);
	}

		
    /**
     * @param centers 中心点List数组 数组中
     */
	public LinearTrend(List<Circle>[] centers, Double centerR, Double inertia, double firstIndex, double secIndex) {
		if (centerR == null || centerR <= 0) {
			this.centerR = Warning.DEFAULT_maxClusterDistance;
		} else {
			this.centerR = centerR;
		}
		
		if (inertia == null || inertia <= 0) {
			this.inertia = Warning.DEFAULT_inertiaRatio;
		} else {
			this.inertia = inertia;
		}
		
		this.firstIndex = firstIndex;
		this.secIndex = secIndex;
		
		this.centers = centers;
		if (centers[0] == null || centers[1] == null) {
			return;
		}
		this.lastCenters = new Circle[centers[1].size()];
		this.init();
	}
	
    private void init(){
        //计算趋势过程
        int alarmNum=centers[1].size();
        for(int k=0;k<alarmNum;k++){

            lastCenters[k]=getNeThunderCenter(centers[1].get(k),centers[0]);
        }
    }

    /**
     * 获取时间戳为index的趋势圆形区域方程
     * @param index
     * @return
     */
    public Circle[] getTrend(double index){
        if(centers[0]==null || centers[1]==null || centers[1].size()<=0){
            return new Circle[0];
        }
        //计算预警区域
        int alarmNum=centers[1].size();
        Circle[] alarms=new Circle[alarmNum];

        for(int k=0;k<alarmNum;k++){
            alarms[k]=getAlarmTrend(lastCenters[k],centers[1].get(k),firstIndex,secIndex,index);
        }
        return alarms;
    }

    public Circle getAlarmTrend(Circle firstCircle, Circle secCircle, double firstIndex, double secIndex, double index) {
        if(firstCircle==null){
            return secCircle;
        }
        Circle re=new Circle();
        re.setX(lineTrend(firstCircle.getX(),secCircle.getX(),firstIndex,secIndex,index));
        re.setY(lineTrend(firstCircle.getY(),secCircle.getY(),firstIndex,secIndex,index));
        re.setR(inertiaTrend(firstCircle.getR(),secCircle.getR(),firstIndex,secIndex,index));
        if(re.getR()<0){
            return null;
        }
        return  re;
    }
    public static double lineTrend(double firstValue,double secValue,double firstIndex,double secIndex,double index){
        if(firstIndex==secIndex){
            return secValue;
        }
        return index*((secValue-firstValue)/(secIndex-firstIndex))+(firstValue-firstIndex*((secValue-firstValue)/(secIndex-firstIndex)));
    }

    protected double inertiaTrend(double firstValue,double secValue,double firstIndex,double secIndex,double index){
        if(firstIndex==secIndex){
            return secValue;
        }
        return (secIndex+inertia*(index-secIndex))*((secValue-firstValue)/(secIndex-firstIndex))+(firstValue-firstIndex*((secValue-firstValue)/(secIndex-firstIndex)));
    }

    /**
     * 获取与雷电中心点最近的雷电中心点坐标
     * @param centers 雷电中心点区域链表
     * @param beCalter 被计算区域雷电中心点
     * @return
     */
	private Circle getNeThunderCenter(Circle beCalter, List<Circle> centers) {
		Circle ne = null;
		Iterator it = centers.iterator();
		Double r = null;
		while (it.hasNext()) {
			Circle center = (Circle) it.next();
			Double tr = getDistanse(center.toArray(), beCalter.toArray());
			if (tr < centerR) {
				if (ne == null || r > tr) {
					r = tr;
					ne = center;
				}
			}
		}

		return ne;
	}
    
    private static double getDistanse(Double[] a,Double[] b){
        return Math.pow(Math.pow(a[0]-b[0],2.0)+Math.pow(a[1]-b[1],2.0),0.5);
    }


    /**
     * 获取某点在某个时间戳下的雷电概率
     * @param lon       经度
     * @param lat       纬度
     * @param index     时间戳
     * @return          概率0~1之间的值0表示概率为0 1表示概率为100%
     */
    public double getRate(double lon,double lat,double index){
        Circle[] cs=getTrend(index);
        return calRate(lon, lat, cs);
    }

    /**
     * 根据经纬度和预警区域获取概率值
     * 该方法在等值线的计算中被用到
     * @param lon
     * @param lat
     * @param cs
     * @return
     */
    public static double calRate(double lon, double lat, Circle[] cs) {
        double re=0.0D;//初始概率为0%
        double p=0.7D;//圆内概率增量
        for(int i=0;i<cs.length;i++){
            Circle c=cs[i];
            if(c==null){continue;}
            double dis=getDistanse(new Double[]{lon,lat},new Double[]{c.getLongitude(),c.getLatitude()});
            if(dis<=c.getR()){
                re=1-(1-re)*(1-p);
            }else{
                re=1-(1-re)*(1-p*Math.pow(c.getR()/dis,2.0));
            }
        }
        if(re>0.901){
            return 0.901;
        }
        return re;
    }

    /**
     * 获取某点在某时间段内的雷电概率数组
     * @param lon           经度
     * @param lat           纬度
     * @param startindex    起始时间戳
     * @param endindex      终止时间戳
     * @return              十条雷电概率数组
     */
    public double[] getRate(double lon,double lat,double startindex,double endindex) {
        int pa=10;//返回数据个数
        double[] re=new double[pa];
        double step=(endindex-startindex )/pa;
        for(int i=0;i<pa;i++){
            re[i]=getRate(lon,lat,startindex+i*step);
        }
        return re;
    }
}