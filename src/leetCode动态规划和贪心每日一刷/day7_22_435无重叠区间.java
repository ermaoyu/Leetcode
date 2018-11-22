package leetCode动态规划和贪心每日一刷;

import java.util.Arrays;
import java.util.Comparator;

/**
 *      毛毛雨     2018/11/8
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
    给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * */
public class day7_22_435无重叠区间 {
    public class Interval {
     int start;
      int end;
     Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end == o2.end)return o1.start - o2.start;
                 return o1.end - o2.end;
            }
        });
        int len = intervals.length;
        int num = 1;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i].start) {
                num++;
                end = intervals[i].end;
            }
        }
        return len - num;
    }
}
