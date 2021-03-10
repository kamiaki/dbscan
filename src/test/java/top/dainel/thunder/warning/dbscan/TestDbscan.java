package top.dainel.thunder.warning.dbscan;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：liudong
 * @date ：Created in 2021/3/9 14:52
 * @description ：测试DBSCAN算法
 */
public class TestDbscan {
    @Test
    public void test1(){
        String jsonStr="[\n" +
                "        {\n" +
                "            \"longtitude\": 110.823,\n" +
                "            \"latitude\": 27.598,\n" +
                "            \"value\": -8.17,\n" +
                "            \"datetime\": 1615219725000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3686,\n" +
                "            \"latitude\": 27.4144,\n" +
                "            \"value\": 7.98,\n" +
                "            \"datetime\": 1615220071000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6125,\n" +
                "            \"latitude\": 27.6992,\n" +
                "            \"value\": 8.97,\n" +
                "            \"datetime\": 1615220442000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4118,\n" +
                "            \"latitude\": 25.3058,\n" +
                "            \"value\": 24.63,\n" +
                "            \"datetime\": 1615220537000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1963,\n" +
                "            \"latitude\": 25.2287,\n" +
                "            \"value\": 47.67,\n" +
                "            \"datetime\": 1615220596000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 117.566,\n" +
                "            \"latitude\": 29.2579,\n" +
                "            \"value\": 26.81,\n" +
                "            \"datetime\": 1615220596000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8719,\n" +
                "            \"latitude\": 24.05,\n" +
                "            \"value\": -19.2,\n" +
                "            \"datetime\": 1615220655000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.0008,\n" +
                "            \"latitude\": 26.8456,\n" +
                "            \"value\": -13.08,\n" +
                "            \"datetime\": 1615220873000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9652,\n" +
                "            \"latitude\": 25.5484,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615220908000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.1135,\n" +
                "            \"latitude\": 27.7264,\n" +
                "            \"value\": 30.07,\n" +
                "            \"datetime\": 1615220919000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5105,\n" +
                "            \"latitude\": 27.225,\n" +
                "            \"value\": 16.22,\n" +
                "            \"datetime\": 1615221131000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2851,\n" +
                "            \"latitude\": 27.3406,\n" +
                "            \"value\": -7.1,\n" +
                "            \"datetime\": 1615221327000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.484,\n" +
                "            \"latitude\": 27.4547,\n" +
                "            \"value\": 9.29,\n" +
                "            \"datetime\": 1615221329000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5187,\n" +
                "            \"latitude\": 27.4209,\n" +
                "            \"value\": 7.44,\n" +
                "            \"datetime\": 1615221461000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6795,\n" +
                "            \"latitude\": 27.2686,\n" +
                "            \"value\": 12.62,\n" +
                "            \"datetime\": 1615221461000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8544,\n" +
                "            \"latitude\": 25.4288,\n" +
                "            \"value\": -16.29,\n" +
                "            \"datetime\": 1615221484000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3602,\n" +
                "            \"latitude\": 27.1495,\n" +
                "            \"value\": -9.15,\n" +
                "            \"datetime\": 1615221575000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.8182,\n" +
                "            \"latitude\": 20.8274,\n" +
                "            \"value\": -27.96,\n" +
                "            \"datetime\": 1615221723000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5084,\n" +
                "            \"latitude\": 27.458,\n" +
                "            \"value\": -10.29,\n" +
                "            \"datetime\": 1615221729000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.268,\n" +
                "            \"latitude\": 27.3159,\n" +
                "            \"value\": 6.09,\n" +
                "            \"datetime\": 1615221774000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3529,\n" +
                "            \"latitude\": 26.9401,\n" +
                "            \"value\": 20.51,\n" +
                "            \"datetime\": 1615222034000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2632,\n" +
                "            \"latitude\": 25.3273,\n" +
                "            \"value\": 15.12,\n" +
                "            \"datetime\": 1615222131000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5337,\n" +
                "            \"latitude\": 26.6248,\n" +
                "            \"value\": -10.13,\n" +
                "            \"datetime\": 1615222168000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6338,\n" +
                "            \"latitude\": 27.4065,\n" +
                "            \"value\": 10.73,\n" +
                "            \"datetime\": 1615222199000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 105.677,\n" +
                "            \"latitude\": 27.0122,\n" +
                "            \"value\": 42.52,\n" +
                "            \"datetime\": 1615222199000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1061,\n" +
                "            \"latitude\": 26.4938,\n" +
                "            \"value\": 10.28,\n" +
                "            \"datetime\": 1615222241000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4206,\n" +
                "            \"latitude\": 25.4725,\n" +
                "            \"value\": -12.34,\n" +
                "            \"datetime\": 1615222248000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4528,\n" +
                "            \"latitude\": 27.417,\n" +
                "            \"value\": -29.05,\n" +
                "            \"datetime\": 1615222256000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8296,\n" +
                "            \"latitude\": 25.4414,\n" +
                "            \"value\": 11.19,\n" +
                "            \"datetime\": 1615222376000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2554,\n" +
                "            \"latitude\": 27.1826,\n" +
                "            \"value\": 9.16,\n" +
                "            \"datetime\": 1615222418000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9063,\n" +
                "            \"latitude\": 25.4686,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615222547000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.7273,\n" +
                "            \"latitude\": 26.9795,\n" +
                "            \"value\": -31.86,\n" +
                "            \"datetime\": 1615222587000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3835,\n" +
                "            \"latitude\": 27.1382,\n" +
                "            \"value\": -5.92,\n" +
                "            \"datetime\": 1615222621000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.2632,\n" +
                "            \"latitude\": 26.8964,\n" +
                "            \"value\": -13.56,\n" +
                "            \"datetime\": 1615222628000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1356,\n" +
                "            \"latitude\": 26.9099,\n" +
                "            \"value\": 17.88,\n" +
                "            \"datetime\": 1615222767000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1722,\n" +
                "            \"latitude\": 25.731,\n" +
                "            \"value\": 19.54,\n" +
                "            \"datetime\": 1615223073000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.271,\n" +
                "            \"latitude\": 25.6071,\n" +
                "            \"value\": -28.39,\n" +
                "            \"datetime\": 1615223096000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.0807,\n" +
                "            \"latitude\": 33.1028,\n" +
                "            \"value\": 5.77,\n" +
                "            \"datetime\": 1615223096000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5883,\n" +
                "            \"latitude\": 25.3565,\n" +
                "            \"value\": 12.5,\n" +
                "            \"datetime\": 1615223110000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9646,\n" +
                "            \"latitude\": 25.4991,\n" +
                "            \"value\": -9.51,\n" +
                "            \"datetime\": 1615223152000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4911,\n" +
                "            \"latitude\": 25.3101,\n" +
                "            \"value\": -18.08,\n" +
                "            \"datetime\": 1615223191000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9116,\n" +
                "            \"latitude\": 27.457,\n" +
                "            \"value\": -16.46,\n" +
                "            \"datetime\": 1615223196000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3655,\n" +
                "            \"latitude\": 25.4733,\n" +
                "            \"value\": 15.14,\n" +
                "            \"datetime\": 1615223279000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.806,\n" +
                "            \"latitude\": 22.5628,\n" +
                "            \"value\": 3.59,\n" +
                "            \"datetime\": 1615223279000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7944,\n" +
                "            \"latitude\": 26.4893,\n" +
                "            \"value\": 8.34,\n" +
                "            \"datetime\": 1615223302000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4061,\n" +
                "            \"latitude\": 25.4658,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615223398000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8195,\n" +
                "            \"latitude\": 25.594,\n" +
                "            \"value\": 9.5,\n" +
                "            \"datetime\": 1615223457000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6728,\n" +
                "            \"latitude\": 26.6634,\n" +
                "            \"value\": 14.68,\n" +
                "            \"datetime\": 1615223539000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2662,\n" +
                "            \"latitude\": 25.5899,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615223570000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6662,\n" +
                "            \"latitude\": 26.6498,\n" +
                "            \"value\": 11.43,\n" +
                "            \"datetime\": 1615223596000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6323,\n" +
                "            \"latitude\": 27.2978,\n" +
                "            \"value\": -8.22,\n" +
                "            \"datetime\": 1615223633000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 115.7637,\n" +
                "            \"latitude\": 22.555,\n" +
                "            \"value\": 18.02,\n" +
                "            \"datetime\": 1615223674000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1526,\n" +
                "            \"latitude\": 25.583,\n" +
                "            \"value\": -14.27,\n" +
                "            \"datetime\": 1615223717000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6481,\n" +
                "            \"latitude\": 21.6669,\n" +
                "            \"value\": 9.9,\n" +
                "            \"datetime\": 1615223790000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8408,\n" +
                "            \"latitude\": 25.684,\n" +
                "            \"value\": 23.05,\n" +
                "            \"datetime\": 1615223791000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0526,\n" +
                "            \"latitude\": 25.5488,\n" +
                "            \"value\": 13.53,\n" +
                "            \"datetime\": 1615223993000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4668,\n" +
                "            \"latitude\": 26.8989,\n" +
                "            \"value\": 38.47,\n" +
                "            \"datetime\": 1615224029000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0742,\n" +
                "            \"latitude\": 25.5638,\n" +
                "            \"value\": 8.15,\n" +
                "            \"datetime\": 1615224075000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8348,\n" +
                "            \"latitude\": 25.5418,\n" +
                "            \"value\": 13.2,\n" +
                "            \"datetime\": 1615224082000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8011,\n" +
                "            \"latitude\": 26.218,\n" +
                "            \"value\": 17.92,\n" +
                "            \"datetime\": 1615224094000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5218,\n" +
                "            \"latitude\": 25.438,\n" +
                "            \"value\": -27.41,\n" +
                "            \"datetime\": 1615224133000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0905,\n" +
                "            \"latitude\": 25.573,\n" +
                "            \"value\": 12.45,\n" +
                "            \"datetime\": 1615224172000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7612,\n" +
                "            \"latitude\": 26.8873,\n" +
                "            \"value\": -10.75,\n" +
                "            \"datetime\": 1615224205000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5463,\n" +
                "            \"latitude\": 25.4358,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615224241000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.4773,\n" +
                "            \"latitude\": 27.0079,\n" +
                "            \"value\": -10.38,\n" +
                "            \"datetime\": 1615224406000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8351,\n" +
                "            \"latitude\": 26.965,\n" +
                "            \"value\": 5.83,\n" +
                "            \"datetime\": 1615224462000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.5763,\n" +
                "            \"latitude\": 25.2626,\n" +
                "            \"value\": -15.3,\n" +
                "            \"datetime\": 1615224464000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5641,\n" +
                "            \"latitude\": 25.4397,\n" +
                "            \"value\": -13.31,\n" +
                "            \"datetime\": 1615224466000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.4973,\n" +
                "            \"latitude\": 33.7196,\n" +
                "            \"value\": -31.94,\n" +
                "            \"datetime\": 1615224507000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.3487,\n" +
                "            \"latitude\": 25.7102,\n" +
                "            \"value\": 10.82,\n" +
                "            \"datetime\": 1615224539000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5297,\n" +
                "            \"latitude\": 27.4899,\n" +
                "            \"value\": 10.06,\n" +
                "            \"datetime\": 1615224542000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.5472,\n" +
                "            \"latitude\": 27.3235,\n" +
                "            \"value\": -10.14,\n" +
                "            \"datetime\": 1615224571000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5837,\n" +
                "            \"latitude\": 25.4708,\n" +
                "            \"value\": 11.48,\n" +
                "            \"datetime\": 1615224581000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4055,\n" +
                "            \"latitude\": 25.4191,\n" +
                "            \"value\": 17.34,\n" +
                "            \"datetime\": 1615224650000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.491,\n" +
                "            \"latitude\": 21.1066,\n" +
                "            \"value\": -5.4,\n" +
                "            \"datetime\": 1615224723000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.7744,\n" +
                "            \"latitude\": 26.6938,\n" +
                "            \"value\": 10.62,\n" +
                "            \"datetime\": 1615224746000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2146,\n" +
                "            \"latitude\": 27.3152,\n" +
                "            \"value\": -7.02,\n" +
                "            \"datetime\": 1615224762000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4325,\n" +
                "            \"latitude\": 26.9417,\n" +
                "            \"value\": 10.34,\n" +
                "            \"datetime\": 1615224773000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4387,\n" +
                "            \"latitude\": 27.4008,\n" +
                "            \"value\": 10.6,\n" +
                "            \"datetime\": 1615224855000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.578,\n" +
                "            \"latitude\": 25.4737,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615224871000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9731,\n" +
                "            \"latitude\": 25.4928,\n" +
                "            \"value\": 9.03,\n" +
                "            \"datetime\": 1615224877000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.0591,\n" +
                "            \"latitude\": 27.2908,\n" +
                "            \"value\": -4.6,\n" +
                "            \"datetime\": 1615224885000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9054,\n" +
                "            \"latitude\": 26.635,\n" +
                "            \"value\": -9.8,\n" +
                "            \"datetime\": 1615224911000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6306,\n" +
                "            \"latitude\": 25.521,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615224933000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4313,\n" +
                "            \"latitude\": 26.981,\n" +
                "            \"value\": -7.03,\n" +
                "            \"datetime\": 1615224962000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8864,\n" +
                "            \"latitude\": 25.5844,\n" +
                "            \"value\": -10.34,\n" +
                "            \"datetime\": 1615225010000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4492,\n" +
                "            \"latitude\": 26.9466,\n" +
                "            \"value\": -12.32,\n" +
                "            \"datetime\": 1615225134000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9369,\n" +
                "            \"latitude\": 26.6412,\n" +
                "            \"value\": 11.35,\n" +
                "            \"datetime\": 1615225317000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8395,\n" +
                "            \"latitude\": 26.735,\n" +
                "            \"value\": 12.88,\n" +
                "            \"datetime\": 1615225317000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8309,\n" +
                "            \"latitude\": 25.5871,\n" +
                "            \"value\": 18.64,\n" +
                "            \"datetime\": 1615225332000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.383,\n" +
                "            \"latitude\": 27.075,\n" +
                "            \"value\": -10.84,\n" +
                "            \"datetime\": 1615225392000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5627,\n" +
                "            \"latitude\": 25.4719,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615225393000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7427,\n" +
                "            \"latitude\": 25.4199,\n" +
                "            \"value\": 12.81,\n" +
                "            \"datetime\": 1615225500000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6435,\n" +
                "            \"latitude\": 25.4925,\n" +
                "            \"value\": 15.81,\n" +
                "            \"datetime\": 1615225500000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6423,\n" +
                "            \"latitude\": 25.548,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615225500000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3904,\n" +
                "            \"latitude\": 27.0539,\n" +
                "            \"value\": -7.43,\n" +
                "            \"datetime\": 1615225534000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8559,\n" +
                "            \"latitude\": 26.7355,\n" +
                "            \"value\": 11.7,\n" +
                "            \"datetime\": 1615225539000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.4796,\n" +
                "            \"latitude\": 25.3826,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615225572000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9766,\n" +
                "            \"latitude\": 25.8075,\n" +
                "            \"value\": 10.21,\n" +
                "            \"datetime\": 1615225589000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6893,\n" +
                "            \"latitude\": 25.26,\n" +
                "            \"value\": 10.21,\n" +
                "            \"datetime\": 1615225634000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3319,\n" +
                "            \"latitude\": 27.0802,\n" +
                "            \"value\": 6.3,\n" +
                "            \"datetime\": 1615225686000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9654,\n" +
                "            \"latitude\": 26.2495,\n" +
                "            \"value\": 14.29,\n" +
                "            \"datetime\": 1615225784000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.542,\n" +
                "            \"latitude\": 26.9724,\n" +
                "            \"value\": 14.32,\n" +
                "            \"datetime\": 1615225788000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7616,\n" +
                "            \"latitude\": 25.4722,\n" +
                "            \"value\": 8.51,\n" +
                "            \"datetime\": 1615225828000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1822,\n" +
                "            \"latitude\": 25.7418,\n" +
                "            \"value\": -8.67,\n" +
                "            \"datetime\": 1615225828000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4154,\n" +
                "            \"latitude\": 26.0777,\n" +
                "            \"value\": -13.3,\n" +
                "            \"datetime\": 1615225935000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5714,\n" +
                "            \"latitude\": 26.9596,\n" +
                "            \"value\": 13.2,\n" +
                "            \"datetime\": 1615225981000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8138,\n" +
                "            \"latitude\": 25.4421,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615225993000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0514,\n" +
                "            \"latitude\": 26.6455,\n" +
                "            \"value\": 11.27,\n" +
                "            \"datetime\": 1615226028000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6999,\n" +
                "            \"latitude\": 25.468,\n" +
                "            \"value\": -12.09,\n" +
                "            \"datetime\": 1615226036000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3198,\n" +
                "            \"latitude\": 25.439,\n" +
                "            \"value\": 18.59,\n" +
                "            \"datetime\": 1615226040000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.626,\n" +
                "            \"latitude\": 26.9082,\n" +
                "            \"value\": 13.56,\n" +
                "            \"datetime\": 1615226042000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8202,\n" +
                "            \"latitude\": 25.4817,\n" +
                "            \"value\": 32.3,\n" +
                "            \"datetime\": 1615226086000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1815,\n" +
                "            \"latitude\": 25.615,\n" +
                "            \"value\": 9.51,\n" +
                "            \"datetime\": 1615226094000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6755,\n" +
                "            \"latitude\": 21.687,\n" +
                "            \"value\": 10.93,\n" +
                "            \"datetime\": 1615226237000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.042,\n" +
                "            \"latitude\": 21.6914,\n" +
                "            \"value\": 22.11,\n" +
                "            \"datetime\": 1615226237000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.188,\n" +
                "            \"latitude\": 25.6554,\n" +
                "            \"value\": 18.24,\n" +
                "            \"datetime\": 1615226281000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.0308,\n" +
                "            \"latitude\": 26.2767,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615226286000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5924,\n" +
                "            \"latitude\": 25.5512,\n" +
                "            \"value\": -18.92,\n" +
                "            \"datetime\": 1615226379000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.008,\n" +
                "            \"latitude\": 26.7503,\n" +
                "            \"value\": 9.02,\n" +
                "            \"datetime\": 1615226585000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3117,\n" +
                "            \"latitude\": 23.9445,\n" +
                "            \"value\": 7.06,\n" +
                "            \"datetime\": 1615226597000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4024,\n" +
                "            \"latitude\": 27.5377,\n" +
                "            \"value\": 18.34,\n" +
                "            \"datetime\": 1615226605000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.7721,\n" +
                "            \"latitude\": 27.5093,\n" +
                "            \"value\": -10.66,\n" +
                "            \"datetime\": 1615226668000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.3912,\n" +
                "            \"latitude\": 25.5881,\n" +
                "            \"value\": -9.24,\n" +
                "            \"datetime\": 1615226681000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.13,\n" +
                "            \"latitude\": 25.23,\n" +
                "            \"value\": 11.02,\n" +
                "            \"datetime\": 1615226706000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.5631,\n" +
                "            \"latitude\": 26.8646,\n" +
                "            \"value\": 12.24,\n" +
                "            \"datetime\": 1615226726000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6678,\n" +
                "            \"latitude\": 26.9589,\n" +
                "            \"value\": 11.1,\n" +
                "            \"datetime\": 1615226823000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4531,\n" +
                "            \"latitude\": 28.2783,\n" +
                "            \"value\": 12.96,\n" +
                "            \"datetime\": 1615226830000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6792,\n" +
                "            \"latitude\": 26.9637,\n" +
                "            \"value\": 10.68,\n" +
                "            \"datetime\": 1615226901000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1699,\n" +
                "            \"latitude\": 25.5874,\n" +
                "            \"value\": 26,\n" +
                "            \"datetime\": 1615226910000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5902,\n" +
                "            \"latitude\": 26.415,\n" +
                "            \"value\": -46.36,\n" +
                "            \"datetime\": 1615226917000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7389,\n" +
                "            \"latitude\": 24.2775,\n" +
                "            \"value\": -6.22,\n" +
                "            \"datetime\": 1615226922000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.5855,\n" +
                "            \"latitude\": 25.3628,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615226931000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1221,\n" +
                "            \"latitude\": 26.7226,\n" +
                "            \"value\": 13.87,\n" +
                "            \"datetime\": 1615226939000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0234,\n" +
                "            \"latitude\": 27.469,\n" +
                "            \"value\": 5.74,\n" +
                "            \"datetime\": 1615226942000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0871,\n" +
                "            \"latitude\": 26.717,\n" +
                "            \"value\": 11.23,\n" +
                "            \"datetime\": 1615226999000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4836,\n" +
                "            \"latitude\": 26.9833,\n" +
                "            \"value\": 12.84,\n" +
                "            \"datetime\": 1615227000000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0421,\n" +
                "            \"latitude\": 26.7406,\n" +
                "            \"value\": 10.6,\n" +
                "            \"datetime\": 1615227019000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8762,\n" +
                "            \"latitude\": 25.4623,\n" +
                "            \"value\": 37.7,\n" +
                "            \"datetime\": 1615227057000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8519,\n" +
                "            \"latitude\": 25.5612,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615227057000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.524,\n" +
                "            \"latitude\": 27.5694,\n" +
                "            \"value\": -18.42,\n" +
                "            \"datetime\": 1615227068000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.1029,\n" +
                "            \"latitude\": 33.0536,\n" +
                "            \"value\": 6.74,\n" +
                "            \"datetime\": 1615227068000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8862,\n" +
                "            \"latitude\": 25.4954,\n" +
                "            \"value\": 18.04,\n" +
                "            \"datetime\": 1615227151000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9066,\n" +
                "            \"latitude\": 25.4831,\n" +
                "            \"value\": 8.39,\n" +
                "            \"datetime\": 1615227213000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8265,\n" +
                "            \"latitude\": 30.3055,\n" +
                "            \"value\": 18.1,\n" +
                "            \"datetime\": 1615227215000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9184,\n" +
                "            \"latitude\": 25.3291,\n" +
                "            \"value\": -12.89,\n" +
                "            \"datetime\": 1615227232000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.3173,\n" +
                "            \"latitude\": 25.6069,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615227259000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.8789,\n" +
                "            \"latitude\": 26.8713,\n" +
                "            \"value\": 8.16,\n" +
                "            \"datetime\": 1615227261000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8561,\n" +
                "            \"latitude\": 26.7784,\n" +
                "            \"value\": 8.35,\n" +
                "            \"datetime\": 1615227283000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.5491,\n" +
                "            \"latitude\": 28.482,\n" +
                "            \"value\": -3.89,\n" +
                "            \"datetime\": 1615227323000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.987,\n" +
                "            \"latitude\": 25.4977,\n" +
                "            \"value\": -30.12,\n" +
                "            \"datetime\": 1615227354000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8959,\n" +
                "            \"latitude\": 25.9392,\n" +
                "            \"value\": 11.65,\n" +
                "            \"datetime\": 1615227354000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.66,\n" +
                "            \"latitude\": 25.7145,\n" +
                "            \"value\": -18.28,\n" +
                "            \"datetime\": 1615227374000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3964,\n" +
                "            \"latitude\": 27.4922,\n" +
                "            \"value\": 7.68,\n" +
                "            \"datetime\": 1615227410000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8554,\n" +
                "            \"latitude\": 26.773,\n" +
                "            \"value\": 8.17,\n" +
                "            \"datetime\": 1615227422000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 120.3526,\n" +
                "            \"latitude\": 26.6619,\n" +
                "            \"value\": -22.76,\n" +
                "            \"datetime\": 1615227438000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.4724,\n" +
                "            \"latitude\": 24.4554,\n" +
                "            \"value\": 19.11,\n" +
                "            \"datetime\": 1615227446000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.6879,\n" +
                "            \"latitude\": 27.3705,\n" +
                "            \"value\": -18.26,\n" +
                "            \"datetime\": 1615227465000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5328,\n" +
                "            \"latitude\": 27.5683,\n" +
                "            \"value\": 6.76,\n" +
                "            \"datetime\": 1615227473000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.98,\n" +
                "            \"latitude\": 25.3366,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615227475000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 115.9872,\n" +
                "            \"latitude\": 24.8382,\n" +
                "            \"value\": -5.14,\n" +
                "            \"datetime\": 1615227475000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.295,\n" +
                "            \"latitude\": 29.9127,\n" +
                "            \"value\": -17.68,\n" +
                "            \"datetime\": 1615227534000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9587,\n" +
                "            \"latitude\": 25.4848,\n" +
                "            \"value\": 10.01,\n" +
                "            \"datetime\": 1615227575000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.6586,\n" +
                "            \"latitude\": 24.2703,\n" +
                "            \"value\": 7.29,\n" +
                "            \"datetime\": 1615227603000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8203,\n" +
                "            \"latitude\": 26.7834,\n" +
                "            \"value\": 10.96,\n" +
                "            \"datetime\": 1615227617000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6689,\n" +
                "            \"latitude\": 25.1198,\n" +
                "            \"value\": 16.74,\n" +
                "            \"datetime\": 1615227639000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6624,\n" +
                "            \"latitude\": 27.6018,\n" +
                "            \"value\": 6.64,\n" +
                "            \"datetime\": 1615227653000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5694,\n" +
                "            \"latitude\": 27.0212,\n" +
                "            \"value\": 10.86,\n" +
                "            \"datetime\": 1615227663000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4341,\n" +
                "            \"latitude\": 25.859,\n" +
                "            \"value\": 9.33,\n" +
                "            \"datetime\": 1615227733000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6026,\n" +
                "            \"latitude\": 27.5851,\n" +
                "            \"value\": 6.91,\n" +
                "            \"datetime\": 1615227744000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3298,\n" +
                "            \"latitude\": 25.2747,\n" +
                "            \"value\": 21.64,\n" +
                "            \"datetime\": 1615227765000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.248,\n" +
                "            \"latitude\": 26.8456,\n" +
                "            \"value\": 12.28,\n" +
                "            \"datetime\": 1615227795000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9738,\n" +
                "            \"latitude\": 25.5062,\n" +
                "            \"value\": 8.33,\n" +
                "            \"datetime\": 1615227796000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6566,\n" +
                "            \"latitude\": 26.6575,\n" +
                "            \"value\": -10.37,\n" +
                "            \"datetime\": 1615227878000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 106.4579,\n" +
                "            \"latitude\": 25.0104,\n" +
                "            \"value\": 30.62,\n" +
                "            \"datetime\": 1615227881000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.5035,\n" +
                "            \"latitude\": 27.4833,\n" +
                "            \"value\": -9.67,\n" +
                "            \"datetime\": 1615227887000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7406,\n" +
                "            \"latitude\": 28.287,\n" +
                "            \"value\": 11.53,\n" +
                "            \"datetime\": 1615228021000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4371,\n" +
                "            \"latitude\": 25.7231,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615228047000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.958,\n" +
                "            \"latitude\": 25.3722,\n" +
                "            \"value\": -16.25,\n" +
                "            \"datetime\": 1615228095000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5649,\n" +
                "            \"latitude\": 26.0647,\n" +
                "            \"value\": 8.66,\n" +
                "            \"datetime\": 1615228145000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4293,\n" +
                "            \"latitude\": 27.4602,\n" +
                "            \"value\": 17.7,\n" +
                "            \"datetime\": 1615228186000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0474,\n" +
                "            \"latitude\": 25.5354,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615228197000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7335,\n" +
                "            \"latitude\": 25.2912,\n" +
                "            \"value\": 15.22,\n" +
                "            \"datetime\": 1615228197000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8382,\n" +
                "            \"latitude\": 25.8448,\n" +
                "            \"value\": 13.84,\n" +
                "            \"datetime\": 1615228197000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1633,\n" +
                "            \"latitude\": 26.7408,\n" +
                "            \"value\": 12.06,\n" +
                "            \"datetime\": 1615228201000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.6339,\n" +
                "            \"latitude\": 27.1942,\n" +
                "            \"value\": 21.2,\n" +
                "            \"datetime\": 1615228202000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1211,\n" +
                "            \"latitude\": 21.3325,\n" +
                "            \"value\": -6.12,\n" +
                "            \"datetime\": 1615228257000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4913,\n" +
                "            \"latitude\": 25.7737,\n" +
                "            \"value\": -17.1,\n" +
                "            \"datetime\": 1615228328000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5497,\n" +
                "            \"latitude\": 24.9411,\n" +
                "            \"value\": 10.26,\n" +
                "            \"datetime\": 1615228372000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5243,\n" +
                "            \"latitude\": 25.5551,\n" +
                "            \"value\": 16.09,\n" +
                "            \"datetime\": 1615228395000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.4575,\n" +
                "            \"latitude\": 28.6126,\n" +
                "            \"value\": -19.53,\n" +
                "            \"datetime\": 1615228410000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.247,\n" +
                "            \"latitude\": 26.4323,\n" +
                "            \"value\": 12.44,\n" +
                "            \"datetime\": 1615228493000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.6824,\n" +
                "            \"latitude\": 25.4194,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615228528000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1532,\n" +
                "            \"latitude\": 25.9178,\n" +
                "            \"value\": 20.63,\n" +
                "            \"datetime\": 1615228563000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4759,\n" +
                "            \"latitude\": 25.5868,\n" +
                "            \"value\": 10.43,\n" +
                "            \"datetime\": 1615228565000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0982,\n" +
                "            \"latitude\": 25.5551,\n" +
                "            \"value\": 15.07,\n" +
                "            \"datetime\": 1615228616000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1803,\n" +
                "            \"latitude\": 24.9116,\n" +
                "            \"value\": 8.38,\n" +
                "            \"datetime\": 1615228655000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8496,\n" +
                "            \"latitude\": 25.7669,\n" +
                "            \"value\": -13.69,\n" +
                "            \"datetime\": 1615228672000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9472,\n" +
                "            \"latitude\": 25.3365,\n" +
                "            \"value\": 20.8,\n" +
                "            \"datetime\": 1615228694000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0222,\n" +
                "            \"latitude\": 24.9258,\n" +
                "            \"value\": 10.1,\n" +
                "            \"datetime\": 1615228733000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2915,\n" +
                "            \"latitude\": 27.8314,\n" +
                "            \"value\": -12.65,\n" +
                "            \"datetime\": 1615228743000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1112,\n" +
                "            \"latitude\": 25.4972,\n" +
                "            \"value\": 26.05,\n" +
                "            \"datetime\": 1615228779000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.143,\n" +
                "            \"latitude\": 27.4118,\n" +
                "            \"value\": -7.37,\n" +
                "            \"datetime\": 1615228828000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5774,\n" +
                "            \"latitude\": 25.6919,\n" +
                "            \"value\": -15.13,\n" +
                "            \"datetime\": 1615228839000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.0728,\n" +
                "            \"latitude\": 27.7173,\n" +
                "            \"value\": -13.79,\n" +
                "            \"datetime\": 1615228870000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4911,\n" +
                "            \"latitude\": 25.26,\n" +
                "            \"value\": 16.05,\n" +
                "            \"datetime\": 1615228908000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0578,\n" +
                "            \"latitude\": 24.2914,\n" +
                "            \"value\": 12.37,\n" +
                "            \"datetime\": 1615229026000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4576,\n" +
                "            \"latitude\": 25.6802,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615229035000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7566,\n" +
                "            \"latitude\": 25.0426,\n" +
                "            \"value\": 15.13,\n" +
                "            \"datetime\": 1615229056000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.5069,\n" +
                "            \"latitude\": 26.8967,\n" +
                "            \"value\": 8.71,\n" +
                "            \"datetime\": 1615229063000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4056,\n" +
                "            \"latitude\": 24.5993,\n" +
                "            \"value\": 10.54,\n" +
                "            \"datetime\": 1615229175000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3988,\n" +
                "            \"latitude\": 25.597,\n" +
                "            \"value\": 25.9,\n" +
                "            \"datetime\": 1615229188000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6523,\n" +
                "            \"latitude\": 24.9223,\n" +
                "            \"value\": 9.7,\n" +
                "            \"datetime\": 1615229196000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1383,\n" +
                "            \"latitude\": 25.4794,\n" +
                "            \"value\": 9.75,\n" +
                "            \"datetime\": 1615229210000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3275,\n" +
                "            \"latitude\": 25.3835,\n" +
                "            \"value\": 17.6,\n" +
                "            \"datetime\": 1615229219000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1642,\n" +
                "            \"latitude\": 25.5213,\n" +
                "            \"value\": 14.44,\n" +
                "            \"datetime\": 1615229232000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1836,\n" +
                "            \"latitude\": 25.1612,\n" +
                "            \"value\": 11.35,\n" +
                "            \"datetime\": 1615229282000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1363,\n" +
                "            \"latitude\": 26.2287,\n" +
                "            \"value\": 10.32,\n" +
                "            \"datetime\": 1615229282000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8562,\n" +
                "            \"latitude\": 26.8847,\n" +
                "            \"value\": -9.37,\n" +
                "            \"datetime\": 1615229297000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.604,\n" +
                "            \"latitude\": 27.9241,\n" +
                "            \"value\": 12.46,\n" +
                "            \"datetime\": 1615229381000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4055,\n" +
                "            \"latitude\": 26.3625,\n" +
                "            \"value\": 19.89,\n" +
                "            \"datetime\": 1615229420000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0939,\n" +
                "            \"latitude\": 24.5946,\n" +
                "            \"value\": -10.34,\n" +
                "            \"datetime\": 1615229431000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.0106,\n" +
                "            \"latitude\": 27.8747,\n" +
                "            \"value\": -64.44,\n" +
                "            \"datetime\": 1615229460000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.3712,\n" +
                "            \"latitude\": 26.9563,\n" +
                "            \"value\": 25.06,\n" +
                "            \"datetime\": 1615229461000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3896,\n" +
                "            \"latitude\": 26.3478,\n" +
                "            \"value\": 23.28,\n" +
                "            \"datetime\": 1615229479000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1862,\n" +
                "            \"latitude\": 25.4769,\n" +
                "            \"value\": -30.59,\n" +
                "            \"datetime\": 1615229512000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.08,\n" +
                "            \"latitude\": 25.8878,\n" +
                "            \"value\": 12.8,\n" +
                "            \"datetime\": 1615229512000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6854,\n" +
                "            \"latitude\": 26.8464,\n" +
                "            \"value\": -11.35,\n" +
                "            \"datetime\": 1615229584000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9053,\n" +
                "            \"latitude\": 27.4399,\n" +
                "            \"value\": 8.93,\n" +
                "            \"datetime\": 1615229584000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.5742,\n" +
                "            \"latitude\": 25.8421,\n" +
                "            \"value\": -29.2,\n" +
                "            \"datetime\": 1615229591000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4514,\n" +
                "            \"latitude\": 25.5911,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615229634000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1716,\n" +
                "            \"latitude\": 25.0637,\n" +
                "            \"value\": -13.46,\n" +
                "            \"datetime\": 1615229655000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8561,\n" +
                "            \"latitude\": 27.4534,\n" +
                "            \"value\": 10.81,\n" +
                "            \"datetime\": 1615229659000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2246,\n" +
                "            \"latitude\": 25.5051,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615229710000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0128,\n" +
                "            \"latitude\": 25.8119,\n" +
                "            \"value\": 18.93,\n" +
                "            \"datetime\": 1615229710000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8681,\n" +
                "            \"latitude\": 27.1979,\n" +
                "            \"value\": -8.16,\n" +
                "            \"datetime\": 1615229760000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2016,\n" +
                "            \"latitude\": 26.4127,\n" +
                "            \"value\": -25.74,\n" +
                "            \"datetime\": 1615229801000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.5101,\n" +
                "            \"latitude\": 25.0508,\n" +
                "            \"value\": -11.74,\n" +
                "            \"datetime\": 1615229828000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2508,\n" +
                "            \"latitude\": 25.5422,\n" +
                "            \"value\": 8.44,\n" +
                "            \"datetime\": 1615229829000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5071,\n" +
                "            \"latitude\": 26.0637,\n" +
                "            \"value\": -27.22,\n" +
                "            \"datetime\": 1615229883000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.6331,\n" +
                "            \"latitude\": 25.7191,\n" +
                "            \"value\": 8.76,\n" +
                "            \"datetime\": 1615229883000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5799,\n" +
                "            \"latitude\": 27.5868,\n" +
                "            \"value\": 7.06,\n" +
                "            \"datetime\": 1615229903000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2763,\n" +
                "            \"latitude\": 27.8794,\n" +
                "            \"value\": -3.87,\n" +
                "            \"datetime\": 1615229967000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7665,\n" +
                "            \"latitude\": 24.969,\n" +
                "            \"value\": 10.25,\n" +
                "            \"datetime\": 1615230006000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2638,\n" +
                "            \"latitude\": 25.4627,\n" +
                "            \"value\": 10.05,\n" +
                "            \"datetime\": 1615230035000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7043,\n" +
                "            \"latitude\": 27.8379,\n" +
                "            \"value\": -9.53,\n" +
                "            \"datetime\": 1615230070000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3899,\n" +
                "            \"latitude\": 27.4191,\n" +
                "            \"value\": -11.19,\n" +
                "            \"datetime\": 1615230099000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2414,\n" +
                "            \"latitude\": 21.7026,\n" +
                "            \"value\": -25.57,\n" +
                "            \"datetime\": 1615230099000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3362,\n" +
                "            \"latitude\": 25.4696,\n" +
                "            \"value\": 13.99,\n" +
                "            \"datetime\": 1615230115000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8783,\n" +
                "            \"latitude\": 28.6252,\n" +
                "            \"value\": -8.84,\n" +
                "            \"datetime\": 1615230200000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.5194,\n" +
                "            \"latitude\": 25.2959,\n" +
                "            \"value\": -17.13,\n" +
                "            \"datetime\": 1615230207000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.7174,\n" +
                "            \"latitude\": 27.4078,\n" +
                "            \"value\": 13.47,\n" +
                "            \"datetime\": 1615230210000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8032,\n" +
                "            \"latitude\": 24.4741,\n" +
                "            \"value\": -10.02,\n" +
                "            \"datetime\": 1615230256000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9218,\n" +
                "            \"latitude\": 25.1998,\n" +
                "            \"value\": 16.76,\n" +
                "            \"datetime\": 1615230257000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.567,\n" +
                "            \"latitude\": 25.6127,\n" +
                "            \"value\": 20.09,\n" +
                "            \"datetime\": 1615230257000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 115.9913,\n" +
                "            \"latitude\": 28.127,\n" +
                "            \"value\": 6.24,\n" +
                "            \"datetime\": 1615230257000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8944,\n" +
                "            \"latitude\": 25.3721,\n" +
                "            \"value\": 38.76,\n" +
                "            \"datetime\": 1615230291000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.6883,\n" +
                "            \"latitude\": 25.5601,\n" +
                "            \"value\": -35.22,\n" +
                "            \"datetime\": 1615230327000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1851,\n" +
                "            \"latitude\": 27.1063,\n" +
                "            \"value\": -9.72,\n" +
                "            \"datetime\": 1615230388000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2854,\n" +
                "            \"latitude\": 27.5516,\n" +
                "            \"value\": -9.05,\n" +
                "            \"datetime\": 1615230420000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6746,\n" +
                "            \"latitude\": 26.8875,\n" +
                "            \"value\": 17.57,\n" +
                "            \"datetime\": 1615230446000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0622,\n" +
                "            \"latitude\": 26.9405,\n" +
                "            \"value\": 18.79,\n" +
                "            \"datetime\": 1615230446000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3186,\n" +
                "            \"latitude\": 25.4598,\n" +
                "            \"value\": -28.97,\n" +
                "            \"datetime\": 1615230480000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.595,\n" +
                "            \"latitude\": 27.256,\n" +
                "            \"value\": -8.6,\n" +
                "            \"datetime\": 1615230517000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6995,\n" +
                "            \"latitude\": 25.2372,\n" +
                "            \"value\": -16.76,\n" +
                "            \"datetime\": 1615230540000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3269,\n" +
                "            \"latitude\": 25.4672,\n" +
                "            \"value\": 45.18,\n" +
                "            \"datetime\": 1615230550000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2837,\n" +
                "            \"latitude\": 24.9124,\n" +
                "            \"value\": -13.64,\n" +
                "            \"datetime\": 1615230550000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2551,\n" +
                "            \"latitude\": 25.6272,\n" +
                "            \"value\": 17.65,\n" +
                "            \"datetime\": 1615230550000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.0675,\n" +
                "            \"latitude\": 25.2574,\n" +
                "            \"value\": -18.92,\n" +
                "            \"datetime\": 1615230591000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.8386,\n" +
                "            \"latitude\": 26.763,\n" +
                "            \"value\": 21.01,\n" +
                "            \"datetime\": 1615230608000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7282,\n" +
                "            \"latitude\": 25.7408,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615230609000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3312,\n" +
                "            \"latitude\": 25.4765,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615230642000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0055,\n" +
                "            \"latitude\": 21.9263,\n" +
                "            \"value\": -7.7,\n" +
                "            \"datetime\": 1615230642000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9965,\n" +
                "            \"latitude\": 27.7209,\n" +
                "            \"value\": 10.34,\n" +
                "            \"datetime\": 1615230683000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8109,\n" +
                "            \"latitude\": 26.8821,\n" +
                "            \"value\": 10,\n" +
                "            \"datetime\": 1615230700000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1911,\n" +
                "            \"latitude\": 26.2079,\n" +
                "            \"value\": -13.37,\n" +
                "            \"datetime\": 1615230739000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.1022,\n" +
                "            \"latitude\": 26.9319,\n" +
                "            \"value\": -21.42,\n" +
                "            \"datetime\": 1615230749000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3659,\n" +
                "            \"latitude\": 25.4726,\n" +
                "            \"value\": 9.11,\n" +
                "            \"datetime\": 1615230791000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.4624,\n" +
                "            \"latitude\": 25.4028,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615230854000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.205,\n" +
                "            \"latitude\": 26.0025,\n" +
                "            \"value\": 16.25,\n" +
                "            \"datetime\": 1615230883000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9458,\n" +
                "            \"latitude\": 28.2263,\n" +
                "            \"value\": 11.62,\n" +
                "            \"datetime\": 1615230891000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7505,\n" +
                "            \"latitude\": 25.7195,\n" +
                "            \"value\": -6.85,\n" +
                "            \"datetime\": 1615230917000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.051,\n" +
                "            \"latitude\": 25.702,\n" +
                "            \"value\": 14.49,\n" +
                "            \"datetime\": 1615230963000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3882,\n" +
                "            \"latitude\": 25.3489,\n" +
                "            \"value\": 12.07,\n" +
                "            \"datetime\": 1615230973000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6882,\n" +
                "            \"latitude\": 25.3261,\n" +
                "            \"value\": 14.86,\n" +
                "            \"datetime\": 1615230973000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.5636,\n" +
                "            \"latitude\": 27.2013,\n" +
                "            \"value\": 6.82,\n" +
                "            \"datetime\": 1615231026000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.6432,\n" +
                "            \"latitude\": 25.5632,\n" +
                "            \"value\": -28.65,\n" +
                "            \"datetime\": 1615231084000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7727,\n" +
                "            \"latitude\": 25.7206,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615231187000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.4617,\n" +
                "            \"latitude\": 26.0479,\n" +
                "            \"value\": 13.89,\n" +
                "            \"datetime\": 1615231223000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.6446,\n" +
                "            \"latitude\": 25.5776,\n" +
                "            \"value\": -33.9,\n" +
                "            \"datetime\": 1615231233000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8994,\n" +
                "            \"latitude\": 27.4158,\n" +
                "            \"value\": 12.3,\n" +
                "            \"datetime\": 1615231235000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.5655,\n" +
                "            \"latitude\": 27.2691,\n" +
                "            \"value\": 5.93,\n" +
                "            \"datetime\": 1615231265000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7116,\n" +
                "            \"latitude\": 27.8696,\n" +
                "            \"value\": 11.9,\n" +
                "            \"datetime\": 1615231304000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4365,\n" +
                "            \"latitude\": 25.5155,\n" +
                "            \"value\": 7.34,\n" +
                "            \"datetime\": 1615231351000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7167,\n" +
                "            \"latitude\": 24.9276,\n" +
                "            \"value\": -23.18,\n" +
                "            \"datetime\": 1615231390000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5236,\n" +
                "            \"latitude\": 25.3189,\n" +
                "            \"value\": 11.95,\n" +
                "            \"datetime\": 1615231482000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8021,\n" +
                "            \"latitude\": 25.7275,\n" +
                "            \"value\": -66.35,\n" +
                "            \"datetime\": 1615231489000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8015,\n" +
                "            \"latitude\": 25.6902,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615231489000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9631,\n" +
                "            \"latitude\": 26.8916,\n" +
                "            \"value\": 8.79,\n" +
                "            \"datetime\": 1615231617000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4725,\n" +
                "            \"latitude\": 25.4068,\n" +
                "            \"value\": 34.39,\n" +
                "            \"datetime\": 1615231660000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.8232,\n" +
                "            \"latitude\": 27.3466,\n" +
                "            \"value\": 11.55,\n" +
                "            \"datetime\": 1615231672000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8648,\n" +
                "            \"latitude\": 25.6437,\n" +
                "            \"value\": -33.63,\n" +
                "            \"datetime\": 1615231681000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7179,\n" +
                "            \"latitude\": 27.237,\n" +
                "            \"value\": 9.36,\n" +
                "            \"datetime\": 1615231697000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.0017,\n" +
                "            \"latitude\": 27.3118,\n" +
                "            \"value\": -10.53,\n" +
                "            \"datetime\": 1615231712000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.4909,\n" +
                "            \"latitude\": 25.5058,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615231760000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7144,\n" +
                "            \"latitude\": 25.1854,\n" +
                "            \"value\": 10.12,\n" +
                "            \"datetime\": 1615231761000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4862,\n" +
                "            \"latitude\": 26.1748,\n" +
                "            \"value\": 25.1,\n" +
                "            \"datetime\": 1615231830000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4562,\n" +
                "            \"latitude\": 21.6627,\n" +
                "            \"value\": 9.87,\n" +
                "            \"datetime\": 1615231851000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.1298,\n" +
                "            \"latitude\": 27.9914,\n" +
                "            \"value\": 12.89,\n" +
                "            \"datetime\": 1615231889000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2377,\n" +
                "            \"latitude\": 26.1491,\n" +
                "            \"value\": 14.88,\n" +
                "            \"datetime\": 1615231901000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1683,\n" +
                "            \"latitude\": 28.5584,\n" +
                "            \"value\": -15.35,\n" +
                "            \"datetime\": 1615231934000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8597,\n" +
                "            \"latitude\": 25.6919,\n" +
                "            \"value\": 9.1,\n" +
                "            \"datetime\": 1615231936000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6956,\n" +
                "            \"latitude\": 25.3557,\n" +
                "            \"value\": -18.78,\n" +
                "            \"datetime\": 1615232023000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8055,\n" +
                "            \"latitude\": 25.5874,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615232060000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.807,\n" +
                "            \"latitude\": 25.5224,\n" +
                "            \"value\": 68.14,\n" +
                "            \"datetime\": 1615232060000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6328,\n" +
                "            \"latitude\": 27.1349,\n" +
                "            \"value\": 12.01,\n" +
                "            \"datetime\": 1615232120000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.4986,\n" +
                "            \"latitude\": 27.1825,\n" +
                "            \"value\": 9.87,\n" +
                "            \"datetime\": 1615232181000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4184,\n" +
                "            \"latitude\": 27.4599,\n" +
                "            \"value\": -7.02,\n" +
                "            \"datetime\": 1615232254000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.8882,\n" +
                "            \"latitude\": 27.34,\n" +
                "            \"value\": 22.47,\n" +
                "            \"datetime\": 1615232300000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3355,\n" +
                "            \"latitude\": 27.0058,\n" +
                "            \"value\": 14.57,\n" +
                "            \"datetime\": 1615232304000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2851,\n" +
                "            \"latitude\": 30.764,\n" +
                "            \"value\": -12.79,\n" +
                "            \"datetime\": 1615232304000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3762,\n" +
                "            \"latitude\": 27.1645,\n" +
                "            \"value\": -9.33,\n" +
                "            \"datetime\": 1615232304000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6758,\n" +
                "            \"latitude\": 26.7638,\n" +
                "            \"value\": -34.58,\n" +
                "            \"datetime\": 1615232332000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7253,\n" +
                "            \"latitude\": 27.8933,\n" +
                "            \"value\": 11.94,\n" +
                "            \"datetime\": 1615232350000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0201,\n" +
                "            \"latitude\": 25.1725,\n" +
                "            \"value\": 56.66,\n" +
                "            \"datetime\": 1615232366000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9894,\n" +
                "            \"latitude\": 25.4857,\n" +
                "            \"value\": 9.51,\n" +
                "            \"datetime\": 1615232385000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7303,\n" +
                "            \"latitude\": 23.7886,\n" +
                "            \"value\": -43.58,\n" +
                "            \"datetime\": 1615232385000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.5041,\n" +
                "            \"latitude\": 25.6046,\n" +
                "            \"value\": 74.95,\n" +
                "            \"datetime\": 1615232386000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6041,\n" +
                "            \"latitude\": 23.8102,\n" +
                "            \"value\": -36.11,\n" +
                "            \"datetime\": 1615232386000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 107.1818,\n" +
                "            \"latitude\": 24.9844,\n" +
                "            \"value\": 24.64,\n" +
                "            \"datetime\": 1615232434000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8753,\n" +
                "            \"latitude\": 26.4823,\n" +
                "            \"value\": -21.51,\n" +
                "            \"datetime\": 1615232441000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.788,\n" +
                "            \"latitude\": 25.3267,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615232497000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8203,\n" +
                "            \"latitude\": 29.0308,\n" +
                "            \"value\": 14.54,\n" +
                "            \"datetime\": 1615232530000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.0083,\n" +
                "            \"latitude\": 24.4877,\n" +
                "            \"value\": -14.1,\n" +
                "            \"datetime\": 1615232553000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.4783,\n" +
                "            \"latitude\": 25.456,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615232556000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.76,\n" +
                "            \"latitude\": 26.7366,\n" +
                "            \"value\": -27.08,\n" +
                "            \"datetime\": 1615232559000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9316,\n" +
                "            \"latitude\": 25.5946,\n" +
                "            \"value\": 29.57,\n" +
                "            \"datetime\": 1615232584000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9276,\n" +
                "            \"latitude\": 25.6194,\n" +
                "            \"value\": 32.3,\n" +
                "            \"datetime\": 1615232630000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9364,\n" +
                "            \"latitude\": 25.614,\n" +
                "            \"value\": -8.76,\n" +
                "            \"datetime\": 1615232630000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.5563,\n" +
                "            \"latitude\": 27.1398,\n" +
                "            \"value\": 7.05,\n" +
                "            \"datetime\": 1615232654000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.937,\n" +
                "            \"latitude\": 25.6283,\n" +
                "            \"value\": 33.28,\n" +
                "            \"datetime\": 1615232706000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8951,\n" +
                "            \"latitude\": 25.2592,\n" +
                "            \"value\": -11.56,\n" +
                "            \"datetime\": 1615232706000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.744,\n" +
                "            \"latitude\": 25.4502,\n" +
                "            \"value\": 14.57,\n" +
                "            \"datetime\": 1615232721000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1102,\n" +
                "            \"latitude\": 27.4883,\n" +
                "            \"value\": 23.61,\n" +
                "            \"datetime\": 1615232748000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8323,\n" +
                "            \"latitude\": 28.466,\n" +
                "            \"value\": -5.52,\n" +
                "            \"datetime\": 1615232748000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7332,\n" +
                "            \"latitude\": 25.5237,\n" +
                "            \"value\": 7.51,\n" +
                "            \"datetime\": 1615232808000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9427,\n" +
                "            \"latitude\": 25.6036,\n" +
                "            \"value\": 71.71,\n" +
                "            \"datetime\": 1615232841000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7547,\n" +
                "            \"latitude\": 26.7086,\n" +
                "            \"value\": -8.41,\n" +
                "            \"datetime\": 1615232872000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 115.6758,\n" +
                "            \"latitude\": 26.4733,\n" +
                "            \"value\": 6.02,\n" +
                "            \"datetime\": 1615232960000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 119.7615,\n" +
                "            \"latitude\": 35.8896,\n" +
                "            \"value\": -7.49,\n" +
                "            \"datetime\": 1615232963000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9345,\n" +
                "            \"latitude\": 25.8712,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615233012000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.0098,\n" +
                "            \"latitude\": 25.5794,\n" +
                "            \"value\": -23.43,\n" +
                "            \"datetime\": 1615233049000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.6954,\n" +
                "            \"latitude\": 25.5141,\n" +
                "            \"value\": 29.49,\n" +
                "            \"datetime\": 1615233053000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3441,\n" +
                "            \"latitude\": 27.2828,\n" +
                "            \"value\": -9.06,\n" +
                "            \"datetime\": 1615233056000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5979,\n" +
                "            \"latitude\": 28.0972,\n" +
                "            \"value\": 5.76,\n" +
                "            \"datetime\": 1615233057000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.0531,\n" +
                "            \"latitude\": 26.1895,\n" +
                "            \"value\": 15.31,\n" +
                "            \"datetime\": 1615233101000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.0232,\n" +
                "            \"latitude\": 26.7411,\n" +
                "            \"value\": 18.99,\n" +
                "            \"datetime\": 1615233101000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.0457,\n" +
                "            \"latitude\": 25.961,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615233115000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4732,\n" +
                "            \"latitude\": 26.1016,\n" +
                "            \"value\": 13.59,\n" +
                "            \"datetime\": 1615233266000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9646,\n" +
                "            \"latitude\": 25.9133,\n" +
                "            \"value\": 27.98,\n" +
                "            \"datetime\": 1615233270000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9656,\n" +
                "            \"latitude\": 25.5876,\n" +
                "            \"value\": 13.64,\n" +
                "            \"datetime\": 1615233282000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9143,\n" +
                "            \"latitude\": 25.4034,\n" +
                "            \"value\": 13.15,\n" +
                "            \"datetime\": 1615233282000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9489,\n" +
                "            \"latitude\": 25.1347,\n" +
                "            \"value\": 13.35,\n" +
                "            \"datetime\": 1615233313000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9491,\n" +
                "            \"latitude\": 25.3154,\n" +
                "            \"value\": -17.19,\n" +
                "            \"datetime\": 1615233334000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6737,\n" +
                "            \"latitude\": 25.3007,\n" +
                "            \"value\": 13.9,\n" +
                "            \"datetime\": 1615233373000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 115.8621,\n" +
                "            \"latitude\": 31.6483,\n" +
                "            \"value\": -12.79,\n" +
                "            \"datetime\": 1615233426000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9496,\n" +
                "            \"latitude\": 27.2618,\n" +
                "            \"value\": -7.69,\n" +
                "            \"datetime\": 1615233432000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 106.9004,\n" +
                "            \"latitude\": 24.9026,\n" +
                "            \"value\": -27.13,\n" +
                "            \"datetime\": 1615233455000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6992,\n" +
                "            \"latitude\": 28.0189,\n" +
                "            \"value\": 7.99,\n" +
                "            \"datetime\": 1615233481000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.9748,\n" +
                "            \"latitude\": 25.3742,\n" +
                "            \"value\": 41,\n" +
                "            \"datetime\": 1615233494000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 121.6464,\n" +
                "            \"latitude\": 25.1663,\n" +
                "            \"value\": -34.04,\n" +
                "            \"datetime\": 1615233494000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.0023,\n" +
                "            \"latitude\": 25.907,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615233503000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.0185,\n" +
                "            \"latitude\": 25.5792,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615233582000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9598,\n" +
                "            \"latitude\": 25.3819,\n" +
                "            \"value\": 13.19,\n" +
                "            \"datetime\": 1615233582000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.986,\n" +
                "            \"latitude\": 25.3402,\n" +
                "            \"value\": 19.98,\n" +
                "            \"datetime\": 1615233609000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.3157,\n" +
                "            \"latitude\": 25.3714,\n" +
                "            \"value\": -19.16,\n" +
                "            \"datetime\": 1615233630000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1414,\n" +
                "            \"latitude\": 25.6268,\n" +
                "            \"value\": -29.4,\n" +
                "            \"datetime\": 1615233664000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.0803,\n" +
                "            \"latitude\": 25.6009,\n" +
                "            \"value\": 7.65,\n" +
                "            \"datetime\": 1615233664000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7927,\n" +
                "            \"latitude\": 25.5239,\n" +
                "            \"value\": -7.21,\n" +
                "            \"datetime\": 1615233685000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.2126,\n" +
                "            \"latitude\": 25.8952,\n" +
                "            \"value\": -10.86,\n" +
                "            \"datetime\": 1615233694000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4173,\n" +
                "            \"latitude\": 25.218,\n" +
                "            \"value\": -15.84,\n" +
                "            \"datetime\": 1615233737000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0082,\n" +
                "            \"latitude\": 25.3586,\n" +
                "            \"value\": 12.65,\n" +
                "            \"datetime\": 1615233782000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.9952,\n" +
                "            \"latitude\": 25.3462,\n" +
                "            \"value\": 11.64,\n" +
                "            \"datetime\": 1615233805000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.514,\n" +
                "            \"latitude\": 25.9026,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615233870000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.59,\n" +
                "            \"latitude\": 27.1585,\n" +
                "            \"value\": -8.92,\n" +
                "            \"datetime\": 1615233880000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1589,\n" +
                "            \"latitude\": 25.6007,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615233901000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.0923,\n" +
                "            \"latitude\": 25.3901,\n" +
                "            \"value\": 11.37,\n" +
                "            \"datetime\": 1615233901000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.7886,\n" +
                "            \"latitude\": 27.147,\n" +
                "            \"value\": -15,\n" +
                "            \"datetime\": 1615233918000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2931,\n" +
                "            \"latitude\": 28.1165,\n" +
                "            \"value\": -12.5,\n" +
                "            \"datetime\": 1615233918000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1031,\n" +
                "            \"latitude\": 25.5885,\n" +
                "            \"value\": 7.47,\n" +
                "            \"datetime\": 1615234014000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6567,\n" +
                "            \"latitude\": 25.4829,\n" +
                "            \"value\": 12.32,\n" +
                "            \"datetime\": 1615234070000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1723,\n" +
                "            \"latitude\": 25.6042,\n" +
                "            \"value\": -36.62,\n" +
                "            \"datetime\": 1615234091000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1019,\n" +
                "            \"latitude\": 25.4064,\n" +
                "            \"value\": 13.05,\n" +
                "            \"datetime\": 1615234091000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1612,\n" +
                "            \"latitude\": 25.0014,\n" +
                "            \"value\": 16.15,\n" +
                "            \"datetime\": 1615234091000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.6398,\n" +
                "            \"latitude\": 25.935,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615234103000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1667,\n" +
                "            \"latitude\": 25.6091,\n" +
                "            \"value\": 8.84,\n" +
                "            \"datetime\": 1615234157000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8572,\n" +
                "            \"latitude\": 25.5256,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615234166000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8029,\n" +
                "            \"latitude\": 25.3178,\n" +
                "            \"value\": -21.58,\n" +
                "            \"datetime\": 1615234185000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6595,\n" +
                "            \"latitude\": 25.4973,\n" +
                "            \"value\": 14.6,\n" +
                "            \"datetime\": 1615234268000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.7429,\n" +
                "            \"latitude\": 25.2113,\n" +
                "            \"value\": -16.85,\n" +
                "            \"datetime\": 1615234296000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.0862,\n" +
                "            \"latitude\": 25.9155,\n" +
                "            \"value\": -14.25,\n" +
                "            \"datetime\": 1615234345000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.4105,\n" +
                "            \"latitude\": 28.7375,\n" +
                "            \"value\": 4.34,\n" +
                "            \"datetime\": 1615234374000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1979,\n" +
                "            \"latitude\": 25.6086,\n" +
                "            \"value\": 8.22,\n" +
                "            \"datetime\": 1615234387000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2117,\n" +
                "            \"latitude\": 25.9984,\n" +
                "            \"value\": -28.25,\n" +
                "            \"datetime\": 1615234473000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.254,\n" +
                "            \"latitude\": 25.5997,\n" +
                "            \"value\": 26.34,\n" +
                "            \"datetime\": 1615234487000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.495,\n" +
                "            \"latitude\": 25.443,\n" +
                "            \"value\": -15.45,\n" +
                "            \"datetime\": 1615234507000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2591,\n" +
                "            \"latitude\": 25.6026,\n" +
                "            \"value\": 21.78,\n" +
                "            \"datetime\": 1615234527000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2956,\n" +
                "            \"latitude\": 25.4517,\n" +
                "            \"value\": 8.68,\n" +
                "            \"datetime\": 1615234543000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.7592,\n" +
                "            \"latitude\": 25.1381,\n" +
                "            \"value\": -17.22,\n" +
                "            \"datetime\": 1615234565000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2558,\n" +
                "            \"latitude\": 25.6013,\n" +
                "            \"value\": -37.32,\n" +
                "            \"datetime\": 1615234609000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1714,\n" +
                "            \"latitude\": 25.3802,\n" +
                "            \"value\": 12.62,\n" +
                "            \"datetime\": 1615234609000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3148,\n" +
                "            \"latitude\": 23.2968,\n" +
                "            \"value\": 6.26,\n" +
                "            \"datetime\": 1615234684000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2964,\n" +
                "            \"latitude\": 25.5938,\n" +
                "            \"value\": -25.53,\n" +
                "            \"datetime\": 1615234701000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2389,\n" +
                "            \"latitude\": 26.0018,\n" +
                "            \"value\": 40.24,\n" +
                "            \"datetime\": 1615234748000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2747,\n" +
                "            \"latitude\": 25.9817,\n" +
                "            \"value\": 4.88,\n" +
                "            \"datetime\": 1615234749000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.1962,\n" +
                "            \"latitude\": 25.3765,\n" +
                "            \"value\": 12.67,\n" +
                "            \"datetime\": 1615234798000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.0721,\n" +
                "            \"latitude\": 27.328,\n" +
                "            \"value\": 12.33,\n" +
                "            \"datetime\": 1615234802000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2562,\n" +
                "            \"latitude\": 26.0033,\n" +
                "            \"value\": -26.71,\n" +
                "            \"datetime\": 1615234831000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2889,\n" +
                "            \"latitude\": 25.6287,\n" +
                "            \"value\": -36.62,\n" +
                "            \"datetime\": 1615234849000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.7844,\n" +
                "            \"latitude\": 25.1839,\n" +
                "            \"value\": -16.35,\n" +
                "            \"datetime\": 1615234862000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6221,\n" +
                "            \"latitude\": 26.9991,\n" +
                "            \"value\": -10.07,\n" +
                "            \"datetime\": 1615234869000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.385,\n" +
                "            \"latitude\": 27.2377,\n" +
                "            \"value\": 7.5,\n" +
                "            \"datetime\": 1615234935000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3848,\n" +
                "            \"latitude\": 27.0797,\n" +
                "            \"value\": 6.58,\n" +
                "            \"datetime\": 1615235011000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9097,\n" +
                "            \"latitude\": 25.6341,\n" +
                "            \"value\": -21.2,\n" +
                "            \"datetime\": 1615235011000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2362,\n" +
                "            \"latitude\": 26.3623,\n" +
                "            \"value\": -16.41,\n" +
                "            \"datetime\": 1615235011000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2824,\n" +
                "            \"latitude\": 25.5439,\n" +
                "            \"value\": -8.02,\n" +
                "            \"datetime\": 1615235028000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.9642,\n" +
                "            \"latitude\": 25.4289,\n" +
                "            \"value\": 43.81,\n" +
                "            \"datetime\": 1615235056000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2721,\n" +
                "            \"latitude\": 26.0261,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615235078000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.3121,\n" +
                "            \"latitude\": 26.0588,\n" +
                "            \"value\": -17.5,\n" +
                "            \"datetime\": 1615235080000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 105.9505,\n" +
                "            \"latitude\": 25.7506,\n" +
                "            \"value\": 30.69,\n" +
                "            \"datetime\": 1615235080000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9238,\n" +
                "            \"latitude\": 25.582,\n" +
                "            \"value\": 10.43,\n" +
                "            \"datetime\": 1615235087000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.0039,\n" +
                "            \"latitude\": 25.4344,\n" +
                "            \"value\": -12.87,\n" +
                "            \"datetime\": 1615235124000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1208,\n" +
                "            \"latitude\": 25.7771,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615235134000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.6019,\n" +
                "            \"latitude\": 25.9039,\n" +
                "            \"value\": -17.41,\n" +
                "            \"datetime\": 1615235148000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2933,\n" +
                "            \"latitude\": 25.5516,\n" +
                "            \"value\": -27.55,\n" +
                "            \"datetime\": 1615235178000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.3549,\n" +
                "            \"latitude\": 25.6232,\n" +
                "            \"value\": -27.75,\n" +
                "            \"datetime\": 1615235203000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0753,\n" +
                "            \"latitude\": 25.2772,\n" +
                "            \"value\": -23.93,\n" +
                "            \"datetime\": 1615235219000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.347,\n" +
                "            \"latitude\": 25.6198,\n" +
                "            \"value\": 8.7,\n" +
                "            \"datetime\": 1615235272000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2825,\n" +
                "            \"latitude\": 26.0359,\n" +
                "            \"value\": 21.66,\n" +
                "            \"datetime\": 1615235319000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7932,\n" +
                "            \"latitude\": 26.3742,\n" +
                "            \"value\": 21.65,\n" +
                "            \"datetime\": 1615235319000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.5592,\n" +
                "            \"latitude\": 26.4712,\n" +
                "            \"value\": 24.57,\n" +
                "            \"datetime\": 1615235319000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4047,\n" +
                "            \"latitude\": 27.192,\n" +
                "            \"value\": -7.43,\n" +
                "            \"datetime\": 1615235326000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7054,\n" +
                "            \"latitude\": 25.4617,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615235388000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6496,\n" +
                "            \"latitude\": 25.4928,\n" +
                "            \"value\": 14.33,\n" +
                "            \"datetime\": 1615235389000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.9518,\n" +
                "            \"latitude\": 24.7844,\n" +
                "            \"value\": 11.49,\n" +
                "            \"datetime\": 1615235389000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.515,\n" +
                "            \"latitude\": 27.1636,\n" +
                "            \"value\": -6.34,\n" +
                "            \"datetime\": 1615235401000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.9555,\n" +
                "            \"latitude\": 25.2527,\n" +
                "            \"value\": -8.9,\n" +
                "            \"datetime\": 1615235403000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.3437,\n" +
                "            \"latitude\": 25.5589,\n" +
                "            \"value\": 45.87,\n" +
                "            \"datetime\": 1615235504000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.342,\n" +
                "            \"latitude\": 25.5351,\n" +
                "            \"value\": 16.78,\n" +
                "            \"datetime\": 1615235504000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2974,\n" +
                "            \"latitude\": 25.5835,\n" +
                "            \"value\": 36.25,\n" +
                "            \"datetime\": 1615235573000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1316,\n" +
                "            \"latitude\": 25.1322,\n" +
                "            \"value\": -12.11,\n" +
                "            \"datetime\": 1615235650000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2889,\n" +
                "            \"latitude\": 27.3227,\n" +
                "            \"value\": 15.05,\n" +
                "            \"datetime\": 1615235731000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.9291,\n" +
                "            \"latitude\": 25.4952,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615235751000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7364,\n" +
                "            \"latitude\": 26.7584,\n" +
                "            \"value\": 7.86,\n" +
                "            \"datetime\": 1615235803000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1958,\n" +
                "            \"latitude\": 25.8182,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615235813000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.3906,\n" +
                "            \"latitude\": 25.5394,\n" +
                "            \"value\": -9.64,\n" +
                "            \"datetime\": 1615235817000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2019,\n" +
                "            \"latitude\": 25.3591,\n" +
                "            \"value\": -12.46,\n" +
                "            \"datetime\": 1615235900000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7862,\n" +
                "            \"latitude\": 25.4759,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615236009000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.052,\n" +
                "            \"latitude\": 25.4179,\n" +
                "            \"value\": 13.92,\n" +
                "            \"datetime\": 1615236015000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.679,\n" +
                "            \"latitude\": 25.9027,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615236022000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4407,\n" +
                "            \"latitude\": 25.3213,\n" +
                "            \"value\": -22.41,\n" +
                "            \"datetime\": 1615236026000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0361,\n" +
                "            \"latitude\": 25.2724,\n" +
                "            \"value\": -20.1,\n" +
                "            \"datetime\": 1615236047000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1202,\n" +
                "            \"latitude\": 25.7592,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615236105000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.0587,\n" +
                "            \"latitude\": 25.4421,\n" +
                "            \"value\": 12.1,\n" +
                "            \"datetime\": 1615236151000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2391,\n" +
                "            \"latitude\": 25.4991,\n" +
                "            \"value\": -36.33,\n" +
                "            \"datetime\": 1615236180000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.485,\n" +
                "            \"latitude\": 25.8057,\n" +
                "            \"value\": 16.97,\n" +
                "            \"datetime\": 1615236182000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8092,\n" +
                "            \"latitude\": 25.5628,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615236242000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8404,\n" +
                "            \"latitude\": 25.6072,\n" +
                "            \"value\": -19.72,\n" +
                "            \"datetime\": 1615236242000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6811,\n" +
                "            \"latitude\": 25.5458,\n" +
                "            \"value\": -30.66,\n" +
                "            \"datetime\": 1615236317000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.5159,\n" +
                "            \"latitude\": 25.6036,\n" +
                "            \"value\": 31.13,\n" +
                "            \"datetime\": 1615236371000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2954,\n" +
                "            \"latitude\": 25.476,\n" +
                "            \"value\": 42.88,\n" +
                "            \"datetime\": 1615236494000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.2799,\n" +
                "            \"latitude\": 25.4765,\n" +
                "            \"value\": -17.57,\n" +
                "            \"datetime\": 1615236494000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.4988,\n" +
                "            \"latitude\": 25.5888,\n" +
                "            \"value\": 5.7,\n" +
                "            \"datetime\": 1615236515000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1589,\n" +
                "            \"latitude\": 25.2948,\n" +
                "            \"value\": -19.84,\n" +
                "            \"datetime\": 1615236527000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.239,\n" +
                "            \"latitude\": 25.6742,\n" +
                "            \"value\": 18.94,\n" +
                "            \"datetime\": 1615236527000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8905,\n" +
                "            \"latitude\": 25.2622,\n" +
                "            \"value\": 16.94,\n" +
                "            \"datetime\": 1615236623000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5084,\n" +
                "            \"latitude\": 25.3324,\n" +
                "            \"value\": -17.02,\n" +
                "            \"datetime\": 1615236631000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8979,\n" +
                "            \"latitude\": 25.2641,\n" +
                "            \"value\": -14.88,\n" +
                "            \"datetime\": 1615236698000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1734,\n" +
                "            \"latitude\": 25.4498,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615236731000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7197,\n" +
                "            \"latitude\": 26.9357,\n" +
                "            \"value\": -7.05,\n" +
                "            \"datetime\": 1615236789000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.208,\n" +
                "            \"latitude\": 27.3866,\n" +
                "            \"value\": -8.92,\n" +
                "            \"datetime\": 1615236801000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6237,\n" +
                "            \"latitude\": 26.9704,\n" +
                "            \"value\": 8.35,\n" +
                "            \"datetime\": 1615236838000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6351,\n" +
                "            \"latitude\": 26.8158,\n" +
                "            \"value\": 8.19,\n" +
                "            \"datetime\": 1615236866000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.5444,\n" +
                "            \"latitude\": 25.5993,\n" +
                "            \"value\": 6.51,\n" +
                "            \"datetime\": 1615236874000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3881,\n" +
                "            \"latitude\": 27.1542,\n" +
                "            \"value\": 8.92,\n" +
                "            \"datetime\": 1615236900000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1718,\n" +
                "            \"latitude\": 25.4519,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615236960000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5018,\n" +
                "            \"latitude\": 25.4358,\n" +
                "            \"value\": 19.98,\n" +
                "            \"datetime\": 1615236971000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2122,\n" +
                "            \"latitude\": 27.2913,\n" +
                "            \"value\": -9.79,\n" +
                "            \"datetime\": 1615237017000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5166,\n" +
                "            \"latitude\": 25.3623,\n" +
                "            \"value\": 15.72,\n" +
                "            \"datetime\": 1615237037000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7933,\n" +
                "            \"latitude\": 25.9044,\n" +
                "            \"value\": -18.07,\n" +
                "            \"datetime\": 1615237054000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7546,\n" +
                "            \"latitude\": 25.9967,\n" +
                "            \"value\": -19.65,\n" +
                "            \"datetime\": 1615237054000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.0411,\n" +
                "            \"latitude\": 26.079,\n" +
                "            \"value\": -16.28,\n" +
                "            \"datetime\": 1615237062000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.3742,\n" +
                "            \"latitude\": 25.4595,\n" +
                "            \"value\": -9.42,\n" +
                "            \"datetime\": 1615237072000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5354,\n" +
                "            \"latitude\": 25.4068,\n" +
                "            \"value\": 13.23,\n" +
                "            \"datetime\": 1615237181000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0086,\n" +
                "            \"latitude\": 25.986,\n" +
                "            \"value\": 13.37,\n" +
                "            \"datetime\": 1615237182000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7366,\n" +
                "            \"latitude\": 25.518,\n" +
                "            \"value\": 18.76,\n" +
                "            \"datetime\": 1615237205000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.081,\n" +
                "            \"latitude\": 23.4754,\n" +
                "            \"value\": 7.3,\n" +
                "            \"datetime\": 1615237205000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8274,\n" +
                "            \"latitude\": 25.5909,\n" +
                "            \"value\": 19.29,\n" +
                "            \"datetime\": 1615237205000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8849,\n" +
                "            \"latitude\": 25.4687,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615237245000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1782,\n" +
                "            \"latitude\": 25.4575,\n" +
                "            \"value\": -47.49,\n" +
                "            \"datetime\": 1615237262000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.2328,\n" +
                "            \"latitude\": 25.1212,\n" +
                "            \"value\": -19.61,\n" +
                "            \"datetime\": 1615237309000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 107.9869,\n" +
                "            \"latitude\": 26.2569,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615237324000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6322,\n" +
                "            \"latitude\": 27.1104,\n" +
                "            \"value\": 8.78,\n" +
                "            \"datetime\": 1615237359000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1438,\n" +
                "            \"latitude\": 25.3837,\n" +
                "            \"value\": -20.62,\n" +
                "            \"datetime\": 1615237360000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 117.1922,\n" +
                "            \"latitude\": 27.1077,\n" +
                "            \"value\": 12.79,\n" +
                "            \"datetime\": 1615237360000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.4108,\n" +
                "            \"latitude\": 25.4745,\n" +
                "            \"value\": 7.11,\n" +
                "            \"datetime\": 1615237367000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2351,\n" +
                "            \"latitude\": 25.4594,\n" +
                "            \"value\": 42.61,\n" +
                "            \"datetime\": 1615237375000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9849,\n" +
                "            \"latitude\": 25.8918,\n" +
                "            \"value\": -15.63,\n" +
                "            \"datetime\": 1615237376000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8662,\n" +
                "            \"latitude\": 25.4017,\n" +
                "            \"value\": 12.58,\n" +
                "            \"datetime\": 1615237420000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.048,\n" +
                "            \"latitude\": 26.2401,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615237442000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.6222,\n" +
                "            \"latitude\": 25.5786,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615237446000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.8627,\n" +
                "            \"latitude\": 27.2013,\n" +
                "            \"value\": 15.38,\n" +
                "            \"datetime\": 1615237508000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0437,\n" +
                "            \"latitude\": 25.3206,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615237509000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6468,\n" +
                "            \"latitude\": 25.4354,\n" +
                "            \"value\": -9.55,\n" +
                "            \"datetime\": 1615237605000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8692,\n" +
                "            \"latitude\": 25.472,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615237614000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7801,\n" +
                "            \"latitude\": 27.2492,\n" +
                "            \"value\": -7.85,\n" +
                "            \"datetime\": 1615237745000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1233,\n" +
                "            \"latitude\": 25.0932,\n" +
                "            \"value\": 12.01,\n" +
                "            \"datetime\": 1615237841000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.449,\n" +
                "            \"latitude\": 25.464,\n" +
                "            \"value\": -12.75,\n" +
                "            \"datetime\": 1615237844000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6029,\n" +
                "            \"latitude\": 25.4207,\n" +
                "            \"value\": -21.68,\n" +
                "            \"datetime\": 1615237848000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 107.9528,\n" +
                "            \"latitude\": 25.3957,\n" +
                "            \"value\": 21.1,\n" +
                "            \"datetime\": 1615237907000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4751,\n" +
                "            \"latitude\": 25.4425,\n" +
                "            \"value\": 12.83,\n" +
                "            \"datetime\": 1615237932000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1261,\n" +
                "            \"latitude\": 25.1141,\n" +
                "            \"value\": -18.29,\n" +
                "            \"datetime\": 1615237946000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.0035,\n" +
                "            \"latitude\": 25.4776,\n" +
                "            \"value\": 11.9,\n" +
                "            \"datetime\": 1615237972000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5795,\n" +
                "            \"latitude\": 25.4033,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615238004000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.9909,\n" +
                "            \"latitude\": 25.4656,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615238076000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0203,\n" +
                "            \"latitude\": 25.4613,\n" +
                "            \"value\": -13.39,\n" +
                "            \"datetime\": 1615238100000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8649,\n" +
                "            \"latitude\": 27.2631,\n" +
                "            \"value\": 6.71,\n" +
                "            \"datetime\": 1615238150000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8587,\n" +
                "            \"latitude\": 25.4324,\n" +
                "            \"value\": -8.64,\n" +
                "            \"datetime\": 1615238204000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4168,\n" +
                "            \"latitude\": 25.2467,\n" +
                "            \"value\": -18.8,\n" +
                "            \"datetime\": 1615238210000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8674,\n" +
                "            \"latitude\": 27.2842,\n" +
                "            \"value\": -7.56,\n" +
                "            \"datetime\": 1615238222000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1923,\n" +
                "            \"latitude\": 25.1435,\n" +
                "            \"value\": -19.56,\n" +
                "            \"datetime\": 1615238269000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2957,\n" +
                "            \"latitude\": 25.4995,\n" +
                "            \"value\": 10.49,\n" +
                "            \"datetime\": 1615238370000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8781,\n" +
                "            \"latitude\": 25.4512,\n" +
                "            \"value\": 10.31,\n" +
                "            \"datetime\": 1615238381000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1982,\n" +
                "            \"latitude\": 25.1462,\n" +
                "            \"value\": -10.55,\n" +
                "            \"datetime\": 1615238408000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5751,\n" +
                "            \"latitude\": 25.3726,\n" +
                "            \"value\": -14.61,\n" +
                "            \"datetime\": 1615238409000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.1806,\n" +
                "            \"latitude\": 27.2219,\n" +
                "            \"value\": 9.04,\n" +
                "            \"datetime\": 1615238428000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1711,\n" +
                "            \"latitude\": 25.4425,\n" +
                "            \"value\": -32.29,\n" +
                "            \"datetime\": 1615238439000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.177,\n" +
                "            \"latitude\": 25.383,\n" +
                "            \"value\": 81.98,\n" +
                "            \"datetime\": 1615238439000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4802,\n" +
                "            \"latitude\": 25.2425,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615238525000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5522,\n" +
                "            \"latitude\": 25.5083,\n" +
                "            \"value\": -23.04,\n" +
                "            \"datetime\": 1615238644000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7145,\n" +
                "            \"latitude\": 27.0521,\n" +
                "            \"value\": 9.38,\n" +
                "            \"datetime\": 1615238692000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2895,\n" +
                "            \"latitude\": 25.467,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615238703000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.9629,\n" +
                "            \"latitude\": 25.4279,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615238716000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.0238,\n" +
                "            \"latitude\": 25.4586,\n" +
                "            \"value\": -30.62,\n" +
                "            \"datetime\": 1615238716000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5834,\n" +
                "            \"latitude\": 25.4217,\n" +
                "            \"value\": -18.29,\n" +
                "            \"datetime\": 1615238727000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6275,\n" +
                "            \"latitude\": 25.3149,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615238800000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1672,\n" +
                "            \"latitude\": 25.9601,\n" +
                "            \"value\": -14.16,\n" +
                "            \"datetime\": 1615238802000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.1231,\n" +
                "            \"latitude\": 28.4442,\n" +
                "            \"value\": 5.58,\n" +
                "            \"datetime\": 1615238876000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6447,\n" +
                "            \"latitude\": 27.4667,\n" +
                "            \"value\": -26.11,\n" +
                "            \"datetime\": 1615238913000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1578,\n" +
                "            \"latitude\": 25.4335,\n" +
                "            \"value\": 47.84,\n" +
                "            \"datetime\": 1615238948000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.0976,\n" +
                "            \"latitude\": 25.6353,\n" +
                "            \"value\": -16.98,\n" +
                "            \"datetime\": 1615239011000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4047,\n" +
                "            \"latitude\": 25.4383,\n" +
                "            \"value\": 12.47,\n" +
                "            \"datetime\": 1615239209000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 118.7801,\n" +
                "            \"latitude\": 25.9477,\n" +
                "            \"value\": -52.89,\n" +
                "            \"datetime\": 1615239236000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3061,\n" +
                "            \"latitude\": 25.9734,\n" +
                "            \"value\": -21.7,\n" +
                "            \"datetime\": 1615239242000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3741,\n" +
                "            \"latitude\": 25.4558,\n" +
                "            \"value\": 10.59,\n" +
                "            \"datetime\": 1615239252000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2738,\n" +
                "            \"latitude\": 25.1543,\n" +
                "            \"value\": 9.69,\n" +
                "            \"datetime\": 1615239359000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4752,\n" +
                "            \"latitude\": 25.1661,\n" +
                "            \"value\": -21.66,\n" +
                "            \"datetime\": 1615239426000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.374,\n" +
                "            \"latitude\": 25.5095,\n" +
                "            \"value\": 10.28,\n" +
                "            \"datetime\": 1615239433000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.6605,\n" +
                "            \"latitude\": 28.4667,\n" +
                "            \"value\": -3.79,\n" +
                "            \"datetime\": 1615239591000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.8703,\n" +
                "            \"latitude\": 31.2321,\n" +
                "            \"value\": -28.73,\n" +
                "            \"datetime\": 1615239622000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3899,\n" +
                "            \"latitude\": 24.6784,\n" +
                "            \"value\": -10.96,\n" +
                "            \"datetime\": 1615239662000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.745,\n" +
                "            \"latitude\": 25.5119,\n" +
                "            \"value\": -17.27,\n" +
                "            \"datetime\": 1615239699000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.3737,\n" +
                "            \"latitude\": 22.6664,\n" +
                "            \"value\": -30.04,\n" +
                "            \"datetime\": 1615239699000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1599,\n" +
                "            \"latitude\": 25.8526,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615239740000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.0832,\n" +
                "            \"latitude\": 25.3768,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615239908000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.2287,\n" +
                "            \"latitude\": 25.8381,\n" +
                "            \"value\": 13.52,\n" +
                "            \"datetime\": 1615240141000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9938,\n" +
                "            \"latitude\": 25.8043,\n" +
                "            \"value\": 14.17,\n" +
                "            \"datetime\": 1615240173000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 117.1228,\n" +
                "            \"latitude\": 27.6692,\n" +
                "            \"value\": -11.17,\n" +
                "            \"datetime\": 1615240272000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1117,\n" +
                "            \"latitude\": 25.4169,\n" +
                "            \"value\": 10.67,\n" +
                "            \"datetime\": 1615240288000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5013,\n" +
                "            \"latitude\": 25.3871,\n" +
                "            \"value\": 13.35,\n" +
                "            \"datetime\": 1615240520000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8715,\n" +
                "            \"latitude\": 25.4978,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615240568000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1077,\n" +
                "            \"latitude\": 25.3822,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615240614000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9562,\n" +
                "            \"latitude\": 25.5329,\n" +
                "            \"value\": -30.78,\n" +
                "            \"datetime\": 1615240685000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.9289,\n" +
                "            \"latitude\": 27.6885,\n" +
                "            \"value\": 8.56,\n" +
                "            \"datetime\": 1615240714000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3132,\n" +
                "            \"latitude\": 25.513,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615240796000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4593,\n" +
                "            \"latitude\": 24.8832,\n" +
                "            \"value\": 12.08,\n" +
                "            \"datetime\": 1615240796000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8933,\n" +
                "            \"latitude\": 25.5028,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615240863000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2941,\n" +
                "            \"latitude\": 25.3136,\n" +
                "            \"value\": -28.48,\n" +
                "            \"datetime\": 1615240863000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2724,\n" +
                "            \"latitude\": 25.3647,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615240961000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7902,\n" +
                "            \"latitude\": 27.0459,\n" +
                "            \"value\": -9.74,\n" +
                "            \"datetime\": 1615241053000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9991,\n" +
                "            \"latitude\": 25.558,\n" +
                "            \"value\": -14.26,\n" +
                "            \"datetime\": 1615241082000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6206,\n" +
                "            \"latitude\": 28.0007,\n" +
                "            \"value\": 10.67,\n" +
                "            \"datetime\": 1615241194000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4853,\n" +
                "            \"latitude\": 25.4933,\n" +
                "            \"value\": 8.99,\n" +
                "            \"datetime\": 1615241253000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9053,\n" +
                "            \"latitude\": 25.3562,\n" +
                "            \"value\": 18.31,\n" +
                "            \"datetime\": 1615241412000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9344,\n" +
                "            \"latitude\": 27.2944,\n" +
                "            \"value\": 7.69,\n" +
                "            \"datetime\": 1615241543000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2446,\n" +
                "            \"latitude\": 25.4607,\n" +
                "            \"value\": 20.75,\n" +
                "            \"datetime\": 1615241827000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8474,\n" +
                "            \"latitude\": 25.1613,\n" +
                "            \"value\": 16.78,\n" +
                "            \"datetime\": 1615241827000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3289,\n" +
                "            \"latitude\": 25.4316,\n" +
                "            \"value\": -10.31,\n" +
                "            \"datetime\": 1615241927000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5763,\n" +
                "            \"latitude\": 25.5128,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615242034000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3646,\n" +
                "            \"latitude\": 25.2814,\n" +
                "            \"value\": -12.35,\n" +
                "            \"datetime\": 1615242094000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.851,\n" +
                "            \"latitude\": 25.5246,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615242106000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6459,\n" +
                "            \"latitude\": 25.1209,\n" +
                "            \"value\": 31.87,\n" +
                "            \"datetime\": 1615242138000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8355,\n" +
                "            \"latitude\": 25.2002,\n" +
                "            \"value\": -48.45,\n" +
                "            \"datetime\": 1615242216000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9128,\n" +
                "            \"latitude\": 25.1771,\n" +
                "            \"value\": -51.37,\n" +
                "            \"datetime\": 1615242216000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6849,\n" +
                "            \"latitude\": 28.8139,\n" +
                "            \"value\": -13.53,\n" +
                "            \"datetime\": 1615242428000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5452,\n" +
                "            \"latitude\": 25.5318,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615242612000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.1538,\n" +
                "            \"latitude\": 25.2253,\n" +
                "            \"value\": -14.27,\n" +
                "            \"datetime\": 1615242612000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7291,\n" +
                "            \"latitude\": 25.5514,\n" +
                "            \"value\": -19.46,\n" +
                "            \"datetime\": 1615242628000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7729,\n" +
                "            \"latitude\": 26.7485,\n" +
                "            \"value\": 17.74,\n" +
                "            \"datetime\": 1615242662000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9025,\n" +
                "            \"latitude\": 25.2077,\n" +
                "            \"value\": -16.67,\n" +
                "            \"datetime\": 1615242695000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3704,\n" +
                "            \"latitude\": 25.3997,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615242729000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.0209,\n" +
                "            \"latitude\": 25.43,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615242965000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.5685,\n" +
                "            \"latitude\": 26.3047,\n" +
                "            \"value\": -17.18,\n" +
                "            \"datetime\": 1615242967000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3685,\n" +
                "            \"latitude\": 25.4245,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615243056000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.674,\n" +
                "            \"latitude\": 25.1211,\n" +
                "            \"value\": 17.23,\n" +
                "            \"datetime\": 1615243056000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5173,\n" +
                "            \"latitude\": 25.1403,\n" +
                "            \"value\": -19.63,\n" +
                "            \"datetime\": 1615243060000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5859,\n" +
                "            \"latitude\": 25.2147,\n" +
                "            \"value\": -26.16,\n" +
                "            \"datetime\": 1615243060000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4994,\n" +
                "            \"latitude\": 27.2368,\n" +
                "            \"value\": -7.16,\n" +
                "            \"datetime\": 1615243268000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.3849,\n" +
                "            \"latitude\": 25.4494,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615243299000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4013,\n" +
                "            \"latitude\": 25.4394,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615243506000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4534,\n" +
                "            \"latitude\": 25.3394,\n" +
                "            \"value\": 12.92,\n" +
                "            \"datetime\": 1615243568000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0655,\n" +
                "            \"latitude\": 25.1402,\n" +
                "            \"value\": 20.74,\n" +
                "            \"datetime\": 1615243574000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2241,\n" +
                "            \"latitude\": 21.5009,\n" +
                "            \"value\": 7.5,\n" +
                "            \"datetime\": 1615243640000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4343,\n" +
                "            \"latitude\": 27.2186,\n" +
                "            \"value\": 6.73,\n" +
                "            \"datetime\": 1615243720000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4135,\n" +
                "            \"latitude\": 25.1477,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615243780000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1784,\n" +
                "            \"latitude\": 25.3111,\n" +
                "            \"value\": 14.53,\n" +
                "            \"datetime\": 1615243848000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.7103,\n" +
                "            \"latitude\": 23.2978,\n" +
                "            \"value\": 27.24,\n" +
                "            \"datetime\": 1615243869000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4629,\n" +
                "            \"latitude\": 27.6145,\n" +
                "            \"value\": -18.82,\n" +
                "            \"datetime\": 1615243872000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4775,\n" +
                "            \"latitude\": 25.3778,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615243976000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7988,\n" +
                "            \"latitude\": 25.0574,\n" +
                "            \"value\": 16.67,\n" +
                "            \"datetime\": 1615243976000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.4873,\n" +
                "            \"latitude\": 25.3783,\n" +
                "            \"value\": 10.87,\n" +
                "            \"datetime\": 1615244016000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2239,\n" +
                "            \"latitude\": 25.3746,\n" +
                "            \"value\": 23.69,\n" +
                "            \"datetime\": 1615244023000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4859,\n" +
                "            \"latitude\": 27.2187,\n" +
                "            \"value\": -7.86,\n" +
                "            \"datetime\": 1615244168000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2061,\n" +
                "            \"latitude\": 25.2548,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615244175000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.552,\n" +
                "            \"latitude\": 25.1911,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615244215000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2259,\n" +
                "            \"latitude\": 21.4878,\n" +
                "            \"value\": 5.67,\n" +
                "            \"datetime\": 1615244215000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 115.4226,\n" +
                "            \"latitude\": 26.3129,\n" +
                "            \"value\": 3.36,\n" +
                "            \"datetime\": 1615244215000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.704,\n" +
                "            \"latitude\": 25.5691,\n" +
                "            \"value\": 9.24,\n" +
                "            \"datetime\": 1615244386000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.6451,\n" +
                "            \"latitude\": 27.0492,\n" +
                "            \"value\": 11.82,\n" +
                "            \"datetime\": 1615244412000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.7157,\n" +
                "            \"latitude\": 25.3737,\n" +
                "            \"value\": 10.83,\n" +
                "            \"datetime\": 1615244503000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.191,\n" +
                "            \"latitude\": 26.1751,\n" +
                "            \"value\": -10.53,\n" +
                "            \"datetime\": 1615244739000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5563,\n" +
                "            \"latitude\": 25.4397,\n" +
                "            \"value\": -11.36,\n" +
                "            \"datetime\": 1615244745000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5098,\n" +
                "            \"latitude\": 25.7527,\n" +
                "            \"value\": 16.18,\n" +
                "            \"datetime\": 1615245023000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5598,\n" +
                "            \"latitude\": 25.4321,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615245053000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.8648,\n" +
                "            \"latitude\": 26.237,\n" +
                "            \"value\": -13.48,\n" +
                "            \"datetime\": 1615245058000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5836,\n" +
                "            \"latitude\": 25.4505,\n" +
                "            \"value\": 8.06,\n" +
                "            \"datetime\": 1615245201000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2812,\n" +
                "            \"latitude\": 25.4227,\n" +
                "            \"value\": -19.97,\n" +
                "            \"datetime\": 1615245261000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.725,\n" +
                "            \"latitude\": 25.172,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615245281000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5852,\n" +
                "            \"latitude\": 25.1848,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615245347000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6147,\n" +
                "            \"latitude\": 25.419,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615245495000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7372,\n" +
                "            \"latitude\": 25.4257,\n" +
                "            \"value\": -18.47,\n" +
                "            \"datetime\": 1615245538000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1055,\n" +
                "            \"latitude\": 25.2775,\n" +
                "            \"value\": 20.7,\n" +
                "            \"datetime\": 1615245556000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.8654,\n" +
                "            \"latitude\": 26.3113,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615245558000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.231,\n" +
                "            \"latitude\": 24.4154,\n" +
                "            \"value\": 13.92,\n" +
                "            \"datetime\": 1615245568000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.8399,\n" +
                "            \"latitude\": 26.2275,\n" +
                "            \"value\": 13.46,\n" +
                "            \"datetime\": 1615245715000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7335,\n" +
                "            \"latitude\": 25.4972,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615245776000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6236,\n" +
                "            \"latitude\": 26.2841,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615246076000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.4964,\n" +
                "            \"latitude\": 23.8446,\n" +
                "            \"value\": 11.03,\n" +
                "            \"datetime\": 1615246114000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.485,\n" +
                "            \"latitude\": 27.2194,\n" +
                "            \"value\": 9.73,\n" +
                "            \"datetime\": 1615246133000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.5781,\n" +
                "            \"latitude\": 25.453,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615246154000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8145,\n" +
                "            \"latitude\": 26.4841,\n" +
                "            \"value\": -11.82,\n" +
                "            \"datetime\": 1615246154000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 117.0888,\n" +
                "            \"latitude\": 28.3049,\n" +
                "            \"value\": 3.32,\n" +
                "            \"datetime\": 1615246241000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6548,\n" +
                "            \"latitude\": 25.4377,\n" +
                "            \"value\": 10.23,\n" +
                "            \"datetime\": 1615246287000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7409,\n" +
                "            \"latitude\": 25.5396,\n" +
                "            \"value\": 29.36,\n" +
                "            \"datetime\": 1615246304000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.6607,\n" +
                "            \"latitude\": 25.4641,\n" +
                "            \"value\": 11.32,\n" +
                "            \"datetime\": 1615246356000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8405,\n" +
                "            \"latitude\": 25.2878,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615246439000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.852,\n" +
                "            \"latitude\": 25.3323,\n" +
                "            \"value\": -17.14,\n" +
                "            \"datetime\": 1615246439000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.5741,\n" +
                "            \"latitude\": 28.5491,\n" +
                "            \"value\": 3.81,\n" +
                "            \"datetime\": 1615246664000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 115.9173,\n" +
                "            \"latitude\": 28.4882,\n" +
                "            \"value\": 9,\n" +
                "            \"datetime\": 1615246664000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2778,\n" +
                "            \"latitude\": 25.4455,\n" +
                "            \"value\": 19.15,\n" +
                "            \"datetime\": 1615246747000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1281,\n" +
                "            \"latitude\": 25.1872,\n" +
                "            \"value\": -15.72,\n" +
                "            \"datetime\": 1615246843000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0131,\n" +
                "            \"latitude\": 25.692,\n" +
                "            \"value\": -10.13,\n" +
                "            \"datetime\": 1615246886000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2651,\n" +
                "            \"latitude\": 25.4024,\n" +
                "            \"value\": 10.84,\n" +
                "            \"datetime\": 1615246898000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4176,\n" +
                "            \"latitude\": 25.1921,\n" +
                "            \"value\": -14.58,\n" +
                "            \"datetime\": 1615246918000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.7927,\n" +
                "            \"latitude\": 25.506,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615247024000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.726,\n" +
                "            \"latitude\": 25.9518,\n" +
                "            \"value\": -12.35,\n" +
                "            \"datetime\": 1615247024000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 118.1092,\n" +
                "            \"latitude\": 27.7504,\n" +
                "            \"value\": -99.26,\n" +
                "            \"datetime\": 1615247171000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8793,\n" +
                "            \"latitude\": 25.5126,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615247460000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.7132,\n" +
                "            \"latitude\": 25.6678,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615247526000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9467,\n" +
                "            \"latitude\": 25.5159,\n" +
                "            \"value\": -9.99,\n" +
                "            \"datetime\": 1615247616000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8593,\n" +
                "            \"latitude\": 25.4886,\n" +
                "            \"value\": -31.99,\n" +
                "            \"datetime\": 1615247616000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8597,\n" +
                "            \"latitude\": 25.5372,\n" +
                "            \"value\": -8.95,\n" +
                "            \"datetime\": 1615247707000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9219,\n" +
                "            \"latitude\": 25.5128,\n" +
                "            \"value\": -8.19,\n" +
                "            \"datetime\": 1615247932000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.107,\n" +
                "            \"latitude\": 25.1442,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615248276000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8261,\n" +
                "            \"latitude\": 25.3088,\n" +
                "            \"value\": 7.6,\n" +
                "            \"datetime\": 1615248452000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0741,\n" +
                "            \"latitude\": 25.5869,\n" +
                "            \"value\": 10.29,\n" +
                "            \"datetime\": 1615248457000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.4413,\n" +
                "            \"latitude\": 27.2344,\n" +
                "            \"value\": 7.29,\n" +
                "            \"datetime\": 1615248466000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5529,\n" +
                "            \"latitude\": 25.4465,\n" +
                "            \"value\": 61.02,\n" +
                "            \"datetime\": 1615248472000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.3361,\n" +
                "            \"latitude\": 25.5583,\n" +
                "            \"value\": -23.38,\n" +
                "            \"datetime\": 1615248472000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.6222,\n" +
                "            \"latitude\": 25.6995,\n" +
                "            \"value\": -16.26,\n" +
                "            \"datetime\": 1615248574000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.7238,\n" +
                "            \"latitude\": 25.6479,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615248775000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0418,\n" +
                "            \"latitude\": 25.6685,\n" +
                "            \"value\": -12.14,\n" +
                "            \"datetime\": 1615248843000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2452,\n" +
                "            \"latitude\": 25.2678,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615249043000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 116.4216,\n" +
                "            \"latitude\": 28.2979,\n" +
                "            \"value\": -5.67,\n" +
                "            \"datetime\": 1615249043000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7951,\n" +
                "            \"latitude\": 28.6874,\n" +
                "            \"value\": 27.61,\n" +
                "            \"datetime\": 1615249043000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9411,\n" +
                "            \"latitude\": 25.4524,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615249207000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6353,\n" +
                "            \"latitude\": 25.3031,\n" +
                "            \"value\": -23.09,\n" +
                "            \"datetime\": 1615249433000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0837,\n" +
                "            \"latitude\": 25.5777,\n" +
                "            \"value\": 32.97,\n" +
                "            \"datetime\": 1615249474000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9891,\n" +
                "            \"latitude\": 25.9769,\n" +
                "            \"value\": -13.77,\n" +
                "            \"datetime\": 1615249474000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7563,\n" +
                "            \"latitude\": 27.2881,\n" +
                "            \"value\": -6.83,\n" +
                "            \"datetime\": 1615249544000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.841,\n" +
                "            \"latitude\": 25.3908,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615249721000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2429,\n" +
                "            \"latitude\": 25.3162,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615249763000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1902,\n" +
                "            \"latitude\": 25.8499,\n" +
                "            \"value\": -15.79,\n" +
                "            \"datetime\": 1615249864000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.468,\n" +
                "            \"latitude\": 27.0979,\n" +
                "            \"value\": -8.04,\n" +
                "            \"datetime\": 1615249999000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.2141,\n" +
                "            \"latitude\": 25.2133,\n" +
                "            \"value\": -42.24,\n" +
                "            \"datetime\": 1615250292000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0346,\n" +
                "            \"latitude\": 25.4877,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615250396000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0308,\n" +
                "            \"latitude\": 25.5748,\n" +
                "            \"value\": -21.84,\n" +
                "            \"datetime\": 1615250396000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8034,\n" +
                "            \"latitude\": 25.1743,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615250443000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6687,\n" +
                "            \"latitude\": 25.2893,\n" +
                "            \"value\": -17.9,\n" +
                "            \"datetime\": 1615250443000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.7688,\n" +
                "            \"latitude\": 25.863,\n" +
                "            \"value\": -11.99,\n" +
                "            \"datetime\": 1615250602000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.069,\n" +
                "            \"latitude\": 25.4777,\n" +
                "            \"value\": 35.72,\n" +
                "            \"datetime\": 1615250609000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.971,\n" +
                "            \"latitude\": 25.9007,\n" +
                "            \"value\": -14.28,\n" +
                "            \"datetime\": 1615250609000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.6742,\n" +
                "            \"latitude\": 25.2789,\n" +
                "            \"value\": -21.32,\n" +
                "            \"datetime\": 1615250665000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1273,\n" +
                "            \"latitude\": 25.5193,\n" +
                "            \"value\": -34.15,\n" +
                "            \"datetime\": 1615250882000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0278,\n" +
                "            \"latitude\": 25.9217,\n" +
                "            \"value\": 13.69,\n" +
                "            \"datetime\": 1615250882000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.121,\n" +
                "            \"latitude\": 26.0073,\n" +
                "            \"value\": -11.81,\n" +
                "            \"datetime\": 1615250974000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5717,\n" +
                "            \"latitude\": 25.5037,\n" +
                "            \"value\": -21.88,\n" +
                "            \"datetime\": 1615251086000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1284,\n" +
                "            \"latitude\": 25.5477,\n" +
                "            \"value\": 29.39,\n" +
                "            \"datetime\": 1615251394000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3783,\n" +
                "            \"latitude\": 27.2396,\n" +
                "            \"value\": -7.17,\n" +
                "            \"datetime\": 1615251445000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.857,\n" +
                "            \"latitude\": 25.3629,\n" +
                "            \"value\": -22.3,\n" +
                "            \"datetime\": 1615251446000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.969,\n" +
                "            \"latitude\": 25.1042,\n" +
                "            \"value\": -7.76,\n" +
                "            \"datetime\": 1615251458000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.7428,\n" +
                "            \"latitude\": 25.2858,\n" +
                "            \"value\": -10.9,\n" +
                "            \"datetime\": 1615251499000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.497,\n" +
                "            \"latitude\": 27.1712,\n" +
                "            \"value\": -10.72,\n" +
                "            \"datetime\": 1615251499000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9509,\n" +
                "            \"latitude\": 25.2562,\n" +
                "            \"value\": 17.44,\n" +
                "            \"datetime\": 1615251567000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2197,\n" +
                "            \"latitude\": 28.4777,\n" +
                "            \"value\": 6.3,\n" +
                "            \"datetime\": 1615251567000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3824,\n" +
                "            \"latitude\": 27.2276,\n" +
                "            \"value\": 7.04,\n" +
                "            \"datetime\": 1615251592000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2173,\n" +
                "            \"latitude\": 25.6031,\n" +
                "            \"value\": -26.33,\n" +
                "            \"datetime\": 1615251619000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.5861,\n" +
                "            \"latitude\": 27.1365,\n" +
                "            \"value\": -10.74,\n" +
                "            \"datetime\": 1615251655000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9824,\n" +
                "            \"latitude\": 25.8479,\n" +
                "            \"value\": -15.84,\n" +
                "            \"datetime\": 1615251728000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.3746,\n" +
                "            \"latitude\": 27.2499,\n" +
                "            \"value\": -7.39,\n" +
                "            \"datetime\": 1615251772000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5219,\n" +
                "            \"latitude\": 25.4388,\n" +
                "            \"value\": -31.71,\n" +
                "            \"datetime\": 1615252029000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.7119,\n" +
                "            \"latitude\": 25.3009,\n" +
                "            \"value\": -27.08,\n" +
                "            \"datetime\": 1615252029000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8973,\n" +
                "            \"latitude\": 25.2812,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615252053000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0578,\n" +
                "            \"latitude\": 25.2793,\n" +
                "            \"value\": -17.99,\n" +
                "            \"datetime\": 1615252144000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9593,\n" +
                "            \"latitude\": 25.4125,\n" +
                "            \"value\": -18.17,\n" +
                "            \"datetime\": 1615252144000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9027,\n" +
                "            \"latitude\": 25.334,\n" +
                "            \"value\": -15.61,\n" +
                "            \"datetime\": 1615252404000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.4761,\n" +
                "            \"latitude\": 27.1532,\n" +
                "            \"value\": 6.19,\n" +
                "            \"datetime\": 1615252490000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2308,\n" +
                "            \"latitude\": 25.4161,\n" +
                "            \"value\": -9.62,\n" +
                "            \"datetime\": 1615252529000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2076,\n" +
                "            \"latitude\": 25.467,\n" +
                "            \"value\": 81.15,\n" +
                "            \"datetime\": 1615252680000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2302,\n" +
                "            \"latitude\": 25.4171,\n" +
                "            \"value\": -33.93,\n" +
                "            \"datetime\": 1615252680000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3358,\n" +
                "            \"latitude\": 25.4754,\n" +
                "            \"value\": -7.57,\n" +
                "            \"datetime\": 1615252727000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9367,\n" +
                "            \"latitude\": 25.2768,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615252745000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8162,\n" +
                "            \"latitude\": 25.4527,\n" +
                "            \"value\": -18.17,\n" +
                "            \"datetime\": 1615252745000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.786,\n" +
                "            \"latitude\": 25.3329,\n" +
                "            \"value\": -20.85,\n" +
                "            \"datetime\": 1615252950000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1861,\n" +
                "            \"latitude\": 25.4633,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615253134000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9088,\n" +
                "            \"latitude\": 25.2255,\n" +
                "            \"value\": 19.05,\n" +
                "            \"datetime\": 1615253134000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2058,\n" +
                "            \"latitude\": 25.3511,\n" +
                "            \"value\": 16.62,\n" +
                "            \"datetime\": 1615253134000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1218,\n" +
                "            \"latitude\": 25.3696,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615253156000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.8216,\n" +
                "            \"latitude\": 25.0811,\n" +
                "            \"value\": -21.6,\n" +
                "            \"datetime\": 1615253156000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1528,\n" +
                "            \"latitude\": 25.4012,\n" +
                "            \"value\": -21.14,\n" +
                "            \"datetime\": 1615253156000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1313,\n" +
                "            \"latitude\": 25.4217,\n" +
                "            \"value\": -26.46,\n" +
                "            \"datetime\": 1615253156000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.2319,\n" +
                "            \"latitude\": 23.3946,\n" +
                "            \"value\": 29.47,\n" +
                "            \"datetime\": 1615253290000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.0512,\n" +
                "            \"latitude\": 26.1052,\n" +
                "            \"value\": -37.59,\n" +
                "            \"datetime\": 1615253306000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3896,\n" +
                "            \"latitude\": 25.5276,\n" +
                "            \"value\": 9.28,\n" +
                "            \"datetime\": 1615253330000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.057,\n" +
                "            \"latitude\": 25.8891,\n" +
                "            \"value\": -12.79,\n" +
                "            \"datetime\": 1615253472000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2712,\n" +
                "            \"latitude\": 25.4934,\n" +
                "            \"value\": 41.35,\n" +
                "            \"datetime\": 1615253546000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1597,\n" +
                "            \"latitude\": 25.8881,\n" +
                "            \"value\": -14.49,\n" +
                "            \"datetime\": 1615253546000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1628,\n" +
                "            \"latitude\": 25.3916,\n" +
                "            \"value\": -10.63,\n" +
                "            \"datetime\": 1615253585000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2226,\n" +
                "            \"latitude\": 24.8657,\n" +
                "            \"value\": -14.69,\n" +
                "            \"datetime\": 1615253621000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3394,\n" +
                "            \"latitude\": 25.4664,\n" +
                "            \"value\": 27.6,\n" +
                "            \"datetime\": 1615253656000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.0622,\n" +
                "            \"latitude\": 25.3836,\n" +
                "            \"value\": 28.5,\n" +
                "            \"datetime\": 1615253659000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2838,\n" +
                "            \"latitude\": 25.4634,\n" +
                "            \"value\": 38.7,\n" +
                "            \"datetime\": 1615253790000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1099,\n" +
                "            \"latitude\": 25.9191,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615253819000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.1443,\n" +
                "            \"latitude\": 25.3749,\n" +
                "            \"value\": 32.5,\n" +
                "            \"datetime\": 1615253824000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0562,\n" +
                "            \"latitude\": 25.2456,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615253833000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9963,\n" +
                "            \"latitude\": 25.8042,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615254318000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4416,\n" +
                "            \"latitude\": 25.5533,\n" +
                "            \"value\": 46.43,\n" +
                "            \"datetime\": 1615254405000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2321,\n" +
                "            \"latitude\": 25.3633,\n" +
                "            \"value\": -15.85,\n" +
                "            \"datetime\": 1615254405000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4484,\n" +
                "            \"latitude\": 25.4373,\n" +
                "            \"value\": -17.48,\n" +
                "            \"datetime\": 1615254405000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2436,\n" +
                "            \"latitude\": 25.8069,\n" +
                "            \"value\": -17.64,\n" +
                "            \"datetime\": 1615254405000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4449,\n" +
                "            \"latitude\": 25.5521,\n" +
                "            \"value\": 51.79,\n" +
                "            \"datetime\": 1615254511000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2385,\n" +
                "            \"latitude\": 25.362,\n" +
                "            \"value\": -17.24,\n" +
                "            \"datetime\": 1615254511000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2967,\n" +
                "            \"latitude\": 25.7868,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615254511000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.705,\n" +
                "            \"latitude\": 25.7623,\n" +
                "            \"value\": -10.91,\n" +
                "            \"datetime\": 1615254609000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.174,\n" +
                "            \"latitude\": 25.2957,\n" +
                "            \"value\": -17.74,\n" +
                "            \"datetime\": 1615254691000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2545,\n" +
                "            \"latitude\": 25.3783,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615254691000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.6923,\n" +
                "            \"latitude\": 25.6747,\n" +
                "            \"value\": 11.05,\n" +
                "            \"datetime\": 1615254860000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1224,\n" +
                "            \"latitude\": 25.916,\n" +
                "            \"value\": -12.71,\n" +
                "            \"datetime\": 1615254983000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3406,\n" +
                "            \"latitude\": 25.4367,\n" +
                "            \"value\": 35.37,\n" +
                "            \"datetime\": 1615254990000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3127,\n" +
                "            \"latitude\": 25.4183,\n" +
                "            \"value\": 28.35,\n" +
                "            \"datetime\": 1615254991000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.5635,\n" +
                "            \"latitude\": 25.5658,\n" +
                "            \"value\": 31.78,\n" +
                "            \"datetime\": 1615255077000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3784,\n" +
                "            \"latitude\": 25.3787,\n" +
                "            \"value\": -16.9,\n" +
                "            \"datetime\": 1615255151000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.5474,\n" +
                "            \"latitude\": 25.596,\n" +
                "            \"value\": 54.13,\n" +
                "            \"datetime\": 1615255274000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.6182,\n" +
                "            \"latitude\": 25.4108,\n" +
                "            \"value\": -15.19,\n" +
                "            \"datetime\": 1615255274000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1724,\n" +
                "            \"latitude\": 25.3558,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615255529000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3918,\n" +
                "            \"latitude\": 25.4849,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615255658000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3168,\n" +
                "            \"latitude\": 25.6481,\n" +
                "            \"value\": 23.99,\n" +
                "            \"datetime\": 1615255658000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.183,\n" +
                "            \"latitude\": 25.3476,\n" +
                "            \"value\": 10.84,\n" +
                "            \"datetime\": 1615255784000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.736,\n" +
                "            \"latitude\": 27.1982,\n" +
                "            \"value\": -6.04,\n" +
                "            \"datetime\": 1615256017000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.3749,\n" +
                "            \"latitude\": 25.4438,\n" +
                "            \"value\": -26.29,\n" +
                "            \"datetime\": 1615256021000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4282,\n" +
                "            \"latitude\": 25.4464,\n" +
                "            \"value\": 70.67,\n" +
                "            \"datetime\": 1615256211000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 112.9988,\n" +
                "            \"latitude\": 21.9623,\n" +
                "            \"value\": -6.43,\n" +
                "            \"datetime\": 1615256211000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.654,\n" +
                "            \"latitude\": 27.0721,\n" +
                "            \"value\": 7.36,\n" +
                "            \"datetime\": 1615256238000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.6915,\n" +
                "            \"latitude\": 27.1527,\n" +
                "            \"value\": -6.37,\n" +
                "            \"datetime\": 1615256427000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4531,\n" +
                "            \"latitude\": 25.4914,\n" +
                "            \"value\": 35.53,\n" +
                "            \"datetime\": 1615256429000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.2429,\n" +
                "            \"latitude\": 25.2749,\n" +
                "            \"value\": -15.27,\n" +
                "            \"datetime\": 1615256429000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1108,\n" +
                "            \"latitude\": 26.2497,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615256481000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7073,\n" +
                "            \"latitude\": 27.1623,\n" +
                "            \"value\": -6.35,\n" +
                "            \"datetime\": 1615256562000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.7986,\n" +
                "            \"latitude\": 27.1933,\n" +
                "            \"value\": -7.8,\n" +
                "            \"datetime\": 1615256562000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.529,\n" +
                "            \"latitude\": 25.4576,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615256618000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.5111,\n" +
                "            \"latitude\": 25.4671,\n" +
                "            \"value\": -55.77,\n" +
                "            \"datetime\": 1615256618000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1303,\n" +
                "            \"latitude\": 26.2595,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615256760000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.4584,\n" +
                "            \"latitude\": 25.5374,\n" +
                "            \"value\": -47.19,\n" +
                "            \"datetime\": 1615256876000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.6125,\n" +
                "            \"latitude\": 25.5315,\n" +
                "            \"value\": 68.27,\n" +
                "            \"datetime\": 1615257182000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.2303,\n" +
                "            \"latitude\": 26.2192,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615257356000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.6434,\n" +
                "            \"latitude\": 25.5238,\n" +
                "            \"value\": 22.3,\n" +
                "            \"datetime\": 1615257427000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.4634,\n" +
                "            \"latitude\": 25.4209,\n" +
                "            \"value\": -12.11,\n" +
                "            \"datetime\": 1615257693000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.678,\n" +
                "            \"latitude\": 25.5482,\n" +
                "            \"value\": -26.74,\n" +
                "            \"datetime\": 1615257809000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8971,\n" +
                "            \"latitude\": 25.774,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615257901000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9441,\n" +
                "            \"latitude\": 25.6845,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615257901000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.9426,\n" +
                "            \"latitude\": 25.6133,\n" +
                "            \"value\": 11.34,\n" +
                "            \"datetime\": 1615258243000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.7918,\n" +
                "            \"latitude\": 25.5246,\n" +
                "            \"value\": 87.94,\n" +
                "            \"datetime\": 1615258725000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.2293,\n" +
                "            \"latitude\": 26.7228,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615259346000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.7628,\n" +
                "            \"latitude\": 24.9022,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615259491000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.8495,\n" +
                "            \"latitude\": 25.6646,\n" +
                "            \"value\": -8.76,\n" +
                "            \"datetime\": 1615259865000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5261,\n" +
                "            \"latitude\": 26.2927,\n" +
                "            \"value\": -9.01,\n" +
                "            \"datetime\": 1615260309000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.9292,\n" +
                "            \"latitude\": 24.9684,\n" +
                "            \"value\": -11.58,\n" +
                "            \"datetime\": 1615260608000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.8062,\n" +
                "            \"latitude\": 25.4063,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615260868000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.9353,\n" +
                "            \"latitude\": 27.2023,\n" +
                "            \"value\": -5.51,\n" +
                "            \"datetime\": 1615267063000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.4835,\n" +
                "            \"latitude\": 27.1668,\n" +
                "            \"value\": 0,\n" +
                "            \"datetime\": 1615268277000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.0009,\n" +
                "            \"latitude\": 27.5198,\n" +
                "            \"value\": 10.81,\n" +
                "            \"datetime\": 1615268637000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.5708,\n" +
                "            \"latitude\": 27.1565,\n" +
                "            \"value\": 10.45,\n" +
                "            \"datetime\": 1615269000000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.8313,\n" +
                "            \"latitude\": 27.19,\n" +
                "            \"value\": -16.86,\n" +
                "            \"datetime\": 1615270295000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.6743,\n" +
                "            \"latitude\": 27.3301,\n" +
                "            \"value\": 13.59,\n" +
                "            \"datetime\": 1615270494000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.8825,\n" +
                "            \"latitude\": 26.7932,\n" +
                "            \"value\": -14.79,\n" +
                "            \"datetime\": 1615271012000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.1951,\n" +
                "            \"latitude\": 27.0476,\n" +
                "            \"value\": 11.22,\n" +
                "            \"datetime\": 1615271227000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.7098,\n" +
                "            \"latitude\": 27.3497,\n" +
                "            \"value\": 13.51,\n" +
                "            \"datetime\": 1615271239000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1499,\n" +
                "            \"latitude\": 26.7788,\n" +
                "            \"value\": -14.81,\n" +
                "            \"datetime\": 1615271575000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2215,\n" +
                "            \"latitude\": 27.4453,\n" +
                "            \"value\": -8.62,\n" +
                "            \"datetime\": 1615271575000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0561,\n" +
                "            \"latitude\": 27.0943,\n" +
                "            \"value\": -21.85,\n" +
                "            \"datetime\": 1615271690000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9303,\n" +
                "            \"latitude\": 27.1706,\n" +
                "            \"value\": -25.9,\n" +
                "            \"datetime\": 1615271895000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.9778,\n" +
                "            \"latitude\": 26.954,\n" +
                "            \"value\": -12.91,\n" +
                "            \"datetime\": 1615271971000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.8639,\n" +
                "            \"latitude\": 27.3244,\n" +
                "            \"value\": -12.28,\n" +
                "            \"datetime\": 1615272247000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.2552,\n" +
                "            \"latitude\": 26.8125,\n" +
                "            \"value\": 13.18,\n" +
                "            \"datetime\": 1615272516000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 108.8151,\n" +
                "            \"latitude\": 26.8173,\n" +
                "            \"value\": -20.08,\n" +
                "            \"datetime\": 1615273036000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.5602,\n" +
                "            \"latitude\": 27.3974,\n" +
                "            \"value\": 7.57,\n" +
                "            \"datetime\": 1615273116000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1179,\n" +
                "            \"latitude\": 27.1714,\n" +
                "            \"value\": 12.8,\n" +
                "            \"datetime\": 1615273223000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1963,\n" +
                "            \"latitude\": 26.9072,\n" +
                "            \"value\": 11.25,\n" +
                "            \"datetime\": 1615273354000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.8592,\n" +
                "            \"latitude\": 27.6612,\n" +
                "            \"value\": 8.36,\n" +
                "            \"datetime\": 1615273354000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3514,\n" +
                "            \"latitude\": 26.847,\n" +
                "            \"value\": 13.21,\n" +
                "            \"datetime\": 1615273627000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.1909,\n" +
                "            \"latitude\": 26.8925,\n" +
                "            \"value\": 10.57,\n" +
                "            \"datetime\": 1615273750000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.2383,\n" +
                "            \"latitude\": 27.0665,\n" +
                "            \"value\": 10.33,\n" +
                "            \"datetime\": 1615273929000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4538,\n" +
                "            \"latitude\": 26.8871,\n" +
                "            \"value\": -11.08,\n" +
                "            \"datetime\": 1615273996000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.1935,\n" +
                "            \"latitude\": 27.3523,\n" +
                "            \"value\": -12.95,\n" +
                "            \"datetime\": 1615274010000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 113.397,\n" +
                "            \"latitude\": 31.0348,\n" +
                "            \"value\": 22.2,\n" +
                "            \"datetime\": 1615274360000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3059,\n" +
                "            \"latitude\": 26.9405,\n" +
                "            \"value\": 13.13,\n" +
                "            \"datetime\": 1615274465000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.2245,\n" +
                "            \"latitude\": 27.1953,\n" +
                "            \"value\": 6.68,\n" +
                "            \"datetime\": 1615274476000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.92,\n" +
                "            \"latitude\": 28.1739,\n" +
                "            \"value\": 3.53,\n" +
                "            \"datetime\": 1615274530000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3192,\n" +
                "            \"latitude\": 26.938,\n" +
                "            \"value\": 12.44,\n" +
                "            \"datetime\": 1615274561000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.0107,\n" +
                "            \"latitude\": 26.0598,\n" +
                "            \"value\": 9.3,\n" +
                "            \"datetime\": 1615274568000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.4372,\n" +
                "            \"latitude\": 27.0041,\n" +
                "            \"value\": 18.97,\n" +
                "            \"datetime\": 1615274657000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9867,\n" +
                "            \"latitude\": 26.9131,\n" +
                "            \"value\": 9.35,\n" +
                "            \"datetime\": 1615274718000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 111.2982,\n" +
                "            \"latitude\": 28.1074,\n" +
                "            \"value\": 9.09,\n" +
                "            \"datetime\": 1615274761000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3336,\n" +
                "            \"latitude\": 26.9493,\n" +
                "            \"value\": 9.49,\n" +
                "            \"datetime\": 1615274796000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 109.3419,\n" +
                "            \"latitude\": 27.219,\n" +
                "            \"value\": 12.94,\n" +
                "            \"datetime\": 1615274920000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 114.3027,\n" +
                "            \"latitude\": 28.175,\n" +
                "            \"value\": -4.59,\n" +
                "            \"datetime\": 1615275030000\n" +
                "        },\n" +
                "        {\n" +
                "            \"longtitude\": 110.9915,\n" +
                "            \"latitude\": 26.8833,\n" +
                "            \"value\": 10.14,\n" +
                "            \"datetime\": 1615275074000\n" +
                "        }\n" +
                "    ]";
        List<Flash> flashs = JSON.parseArray(jsonStr,Flash.class);
        Long min=null;
        Long max=null;
        for (Flash flash:flashs){
            if (min==null){
                min=flash.datetime.getTime();
                max=flash.datetime.getTime();
            }else{
                if (min>flash.datetime.getTime()){
                    min=flash.datetime.getTime();
                }
                if (max<flash.datetime.getTime()){
                    max=flash.datetime.getTime();
                }
            }
        }
        //雷簇半径：默认为0.1
        double clusterRadiusDbl = 0.1;
        // 前后雷簇最大间距：默认为0.5
        double maxClusterDistanceDbl = 0.5;
        // 雷簇数量：默认为3
        int clusterThunderCountInt = 3;
        Warning warning=new Warning(flashs,new Timestamp(min),new Timestamp(max));
        warning.init(clusterThunderCountInt,clusterRadiusDbl, maxClusterDistanceDbl);
        LinearTrend linearTrend =new LinearTrend(warning.getCenters(),maxClusterDistanceDbl, 0.6, 1,2);//采用Trend类来计算趋势
        Map map=new HashMap();
        map.put("thunders",warning.getDatas());
        map.put("centers",warning.getCenters());
        map.put("alarms",linearTrend.getTrend(3.0));
        map.put("lastcenters",linearTrend.getLastCenters());

    }
    @Test
    public void testLongToInt(){
        long l=Long.MAX_VALUE;
        int a=(int) l;
        System.out.println(a);
    }
}
