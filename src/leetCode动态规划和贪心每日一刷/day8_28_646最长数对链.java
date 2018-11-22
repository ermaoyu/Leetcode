package leetCode动态规划和贪心每日一刷;

import java.util.Arrays;
import java.util.Comparator;

/**
 *      毛毛雨     2018/11/10
 * */
public class day8_28_646最长数对链 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1])return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        int sum = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > end){
                sum++;
                end = pairs[i][1];
            }
        }
        return sum;
    }
}
