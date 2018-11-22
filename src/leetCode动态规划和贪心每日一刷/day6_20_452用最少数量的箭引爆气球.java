package leetCode动态规划和贪心每日一刷;

import java.util.Arrays;
import java.util.Comparator;

/**
 *      毛毛雨     2018/10/7
 * */
/**
 * 左边已经没有气球了；
 * 本次投飞镖能够刺破最多的气球。
 * */
public class day6_20_452用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)return 0;
        Arrays.sort(points, new Comparator<int[]>() {//要使刺破的气球最多,按照气球的end排序
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int curPos = points[0][1];//左边第一个气球的开始
        int ret = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= curPos){//右边气球的start小于左侧气球的end,还没到最大气球
                continue;
            }
            curPos = points[i][1];//更新左侧气球
            ret ++;//次数加一
        }
        return ret;
    }
}
