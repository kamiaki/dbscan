package top.dainel.thunder.warning.dbscan;




import top.dainel.thunder.warning.dbscan.flashcomparater.FlashTimeComparator;

import java.sql.Timestamp;
import java.util.*;


/**
 * Created by liudong on 2017/11/15.
 */
public class Warning {
	
	// 雷簇半径：默认为0.1
	public static final double DEFAULT_clusterRadius = 0.1;
	// 前后雷簇最大间距：默认为0.5
	public static final double DEFAULT_maxClusterDistance = 0.5;
	// 惰性系数：默认为0.6
	public static final double DEFAULT_inertiaRatio = 0.6;
	// 雷簇数量：默认为3
	public static final int DEFAULT_clusterThunderCount = 3;
	
    private List<? extends Flash> thunderList;
    private Flash[] thunders;//存储雷电数组
    private Timestamp startTime;//开始时间
    private Timestamp endTime;//结束时间
    private int paragraph=2;//分割段数
    private long[] sts=new long[paragraph];//分割时间点 单位毫秒
    private DBSCAN d;//分类算法
    private List<Circle>[]  centers=new List[paragraph];//中心点坐标链表
    private List<List<List<Point>>> clusedPoints=new LinkedList<>();//分组后的点
    private double centerR=0.5;//中心点最远距离 超过该距离则不作为同一雷云处理
    private double clusterRadius;
    private Double[][] alarmCenters;//报警中心点位置;
    private Double[][][] neThunderCenter;//最近几次闪电中心点位置

    public Double[][][] getNeThunderCenter() {
        return neThunderCenter;
    }

    public Double[][] getAlarmCenters() {
        return alarmCenters;
    }

    public Warning(List<? extends Flash> thunders) {
        this.thunderList=thunders;
    }
    public Warning(List<? extends Flash> thunders, Timestamp startTime, Timestamp endTime){
        this(thunders);
        this.startTime=startTime;
        this.endTime=endTime;
    }
    
    public void init(int clusterThunderCount){
    	init(clusterThunderCount, DEFAULT_clusterRadius, DEFAULT_maxClusterDistance);
    }
    
    /**
     * 
     * @param clusterThunderCount: 一个簇里雷的最小数量。默认为3.
     */
    public void init(int clusterThunderCount, double clusterRadius, double maxClusterDistance){
    	this.clusterRadius = clusterRadius;
    	this.centerR = maxClusterDistance;
        Collections.sort(thunderList,new FlashTimeComparator());
        Iterator it=thunderList.iterator();
        int len=thunderList.size();//雷电的个数
        if(len<=0){return;}
        thunders=new Flash[len];
        //points=new SamplePoint[len];
        int i=0;
        while(it.hasNext()){
            thunders[i]=(Flash)it.next();

            //points[i]=new SamplePoint(i,new double[]{thunders[i].getLongtitude(),thunders[i].getLatitude()});
            i++;
        }

        if(startTime==null){
            startTime=thunders[0].getDatetime();
        }
        if(endTime==null){
            endTime=thunders[len-1].getDatetime();
        }


        long st=(endTime.getTime()-startTime.getTime())/paragraph;
        int[] indexs=new int[paragraph];//每段第一个雷电的下标
        Timestamp[] startTimes=new Timestamp[paragraph];//每段的开始时间
        startTimes[0]=startTime;
        for(i=1;i<paragraph;i++){
            startTimes[i]=new Timestamp(startTime.getTime()+st*i);
        }
        //计算雷电下标
        int j=0;
        if(len>0) indexs[0]=0;
        for(i=1;i<paragraph;i++){
            for(;j<len;j++){
                Timestamp t=thunders[j].getDatetime();

                if(t.after(startTimes[i])){
                    indexs[i]=j;
                    break;
                }
            }
        }
        if(indexs[paragraph-1]==0)indexs[paragraph-1]=len-1;

        //计算雷电中心点
        for(int n=0;n<paragraph;n++) {
            List<Point> data = new LinkedList<>();
            int startIndex=indexs[n];
            int endIndex=n==paragraph-1?len:indexs[n+1];
            for (i = startIndex; i < endIndex; i++) {
                List<Double> location = new ArrayList<Double>();
                location.add(thunders[i].getLongtitude());
                location.add(thunders[i].getLatitude());
                data.add(new Point(i - indexs[n], location, 0));
            }
            d = new DBSCAN(this.clusterRadius, (clusterThunderCount <= 3 ? 3 : clusterThunderCount));//选用dbscan算法进行聚类 半径0.1 最小点数为3
            d.cluster(data);
            this.clusedPoints.add(d.getMicroCluster());
            centers[n]=calCenters(d.getMicroCluster());

        }



    }

    public void calTrend() {
        //计算预警区域
        int alarmNum=centers[paragraph-1].size();
        alarmCenters=new Double[alarmNum][3];//预警个数等于最近闪电簇个数
        neThunderCenter=new Double[paragraph][alarmNum][];//最近n次闪电中心点位置
        for(int m=0;m<paragraph;m++){
            for(int k=0;k<alarmNum;k++){
                if(m==0){
                    //倒数第一组雷电簇==
                    neThunderCenter[0][k]=centers[paragraph-1].get(k).toArray();//获取最近的雷电区域中心点
                }else{
                    //计算倒数第m次雷电区域中心点
                    if(neThunderCenter[m-1][k]!=null) {
                        neThunderCenter[m][k] = getNeThunderCenter(neThunderCenter[m - 1][k], centers[paragraph - (1 + m)]);//获取最近的雷电区域中心点
                    }
                }
            }
        }
        //计算预警区域中心点

        for(int k=0;k<alarmNum;k++){ 
            alarmCenters[k]=calAlarmCenter(neThunderCenter,k);//通过最近一次的中心点和之前的中心点位置来计算
        }
    }

    /**
     * 根据雷电趋势计算预警中心点
     * @param neThunderCenter   被计算雷电上n次中心点位置
     * @return                  预警中心点
     */
    private Double[] calAlarmCenter( Double[][][] neThunderCenter,int k) {
        if(neThunderCenter[1][k]==null){
            return neThunderCenter[0][k];
        }
        if(neThunderCenter[2][k]==null){
            return getCCenter(neThunderCenter[0][k],neThunderCenter[1][k]);//计算线性趋势
        }else{
            return getCCenter(neThunderCenter[0][k],neThunderCenter[1][k]);//计算线性趋势
            //return getPCenter(center,neThunderCenter[0][k],neThunderCenter[1][k]);//计算抛物线趋势
        }

    }

    /**
     * 计算抛物线趋势
     * @param center    倒数第一点
     * @param bcenter   倒数第二点
     * @param bbcenter  倒数第三点
     * @return
     */
    private Double[] getPCenter(Double[] center, Double[] bcenter, Double[] bbcenter) {
        Double[] re=new Double[2];
        re[0]=calPaoT(center[0],bcenter[0],bbcenter[0]);
        re[1]=calPaoT(center[1],bcenter[1],bbcenter[1]);
        return  re;
    }

    private Double calPaoT(Double x3, Double x2, Double x1) {
        return 3.0*x3-3.0*x2+x1;
    }

    /**
     * 计算线性趋势
     * @param center    当前中心点坐标
     * @param bcenter   前一中心点
     * @return          预警点
     */
    private Double[] getCCenter(Double[] center, Double[] bcenter) {
        Double[] re=new Double[3];
        re[0]=calLineT(center[0],bcenter[0]);//计算x
        re[1]=calLineT(center[1],bcenter[1]);//计算y
        re[2]=calLineT(center[2],bcenter[2]);//计算半径
        if(re[2]<=0){
            re=null;
        }
        return  re;
    }

    private Double calLineT(Double x2, Double x1) {
        //at+b=x
        return 2*x2-x1;//t=0 1 2
        //return 1.6*x2-0.6*x1;//t=0 1 1.6
    }


    /**
     * 获取与雷电中心点最近的雷电中心点坐标
     * @param centers 雷电中心点区域链表
     * @param beCalter 被计算区域雷电中心点
     * @return
     */
    private Double[] getNeThunderCenter(Double[] beCalter, List<Circle> centers) {
        Double[] ne=new Double[3];
        Double r=null;
        Iterator<Circle> it=centers.iterator();
        while (it.hasNext()){
            Double[] center=it.next().toArray();
            Double tr=getDistanse(center,beCalter);
            if(r==null || r>tr){
                r=tr;
                ne=center;
            }
        }
        if(r<centerR){
            return ne;
        }else {
            return null;
        }

    }
    private static double getDistanse(Double[] a,Double[] b){
        return Math.pow(Math.pow(a[0]-b[0],2.0)+Math.pow(a[1]-b[1],2.0),0.5);
    }

    private List<Circle> calCenters(List<List<Point>> microCluster) {
        List<Circle> re=new ArrayList<>();
        Iterator it=microCluster.iterator();
        while (it.hasNext()){
            re.add(calCenter((List<Point>)it.next()));
        }
        return re;
    }

    private Circle calCenter(List<Point> points) {
        Circle re=new Circle();
        Iterator it=points.iterator();
        double len=points.size();
        while (it.hasNext()){
            Point p=(Point)it.next();
            re.addX(p.getLocation().get(0));
            re.addY(p.getLocation().get(1));
        }
        re.set(0,re.get(0)/len);
        re.set(1,re.get(1)/len);
        re.set(2,calR(re.toArray(),points));
        return re;

    }

    /**
     * 计算雷电簇半径
     * @param re        中心点坐标
     * @param points    点集
     * @return          雷电区域半径
     */
    private Double calR(Double[] re, List<Point> points) {
        Iterator it=points.iterator();
        Double r=null;
        while (it.hasNext()){
            Point tp =(Point) it.next();
            double dis=getDistanse(re,new Double[]{tp.getLocation().get(0),tp.getLocation().get(1)});
            if(r==null || r<dis){
                r=dis;
            }
        }
        return r;
    }

    public List<List<List<Point>>> getDatas(){
        return this.clusedPoints;
    }
    public List<Circle>[] getCenters(){
        return this.centers;
    }

}
