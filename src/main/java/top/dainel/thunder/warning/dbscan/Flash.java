package top.dainel.thunder.warning.dbscan;

import java.sql.Timestamp;

/**
 * @author ：liudong
 * @date ：Created in 2020-05-11 11:24
 * @description：闪电类 要想传入的数据支持该算法 必须继承该类
 */
public class Flash {
    // 经度
    protected Double longtitude;
    // 纬度
    protected Double latitude;
    // 日期
    protected Timestamp datetime;

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
