package top.dainel.thunder.warning.dbscan.flashcomparater;

import top.dainel.thunder.warning.dbscan.Flash;

import java.util.Comparator;

/**
 * @author ：liudong
 * @date ：Created in 2021/3/10 10:38
 * @description ：雷电时间比较器
 */
public class FlashTimeComparator implements Comparator<Flash> {

    @Override
    public int compare(Flash o1, Flash o2) {
        return  Long.compare(o1.getDatetime().getTime(),o2.getDatetime().getTime());
    }
}
