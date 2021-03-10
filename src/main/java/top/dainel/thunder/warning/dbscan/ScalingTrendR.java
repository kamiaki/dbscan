package top.dainel.thunder.warning.dbscan;

import java.util.List;

/**
 * 线性趋势计算器
 * 经纬度坐标成线性增长
 * 半径坐标增加惰性系数
 */
public class ScalingTrendR extends LinearTrend{
    
    /**
     * @param centers 中心点List数组 数组中
     */
	public ScalingTrendR(List<Circle>[] centers, double firstIndex, double secIndex) {
		this(centers, null, firstIndex, secIndex);
	}
		
    /**
     * @param centers 中心点List数组 数组中
     */
	public ScalingTrendR(List<Circle>[] centers, Double centerR, double firstIndex, double secIndex) {
		super(centers, centerR, null, firstIndex, secIndex);
	}
	
	protected  double inertiaTrend(double firstValue,double secValue,double firstIndex,double secIndex,double index){
        if(firstIndex==secIndex){
            return secValue;
        }
        //return (secIndex+inertia*(index-secIndex))*((secValue-firstValue)/(secIndex-firstIndex))+(firstValue-firstIndex*((secValue-firstValue)/(secIndex-firstIndex)));
        double r = secValue * Math.pow((secValue / firstValue), (index - secIndex) / (secIndex - firstIndex));
        if (r < 0.01) {
        	r = -1;
        } else if (r > secValue * 3) {
        	r = secValue * 3;
        }
        return r;
	}

}