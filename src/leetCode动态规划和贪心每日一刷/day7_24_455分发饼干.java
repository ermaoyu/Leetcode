package leetCode动态规划和贪心每日一刷;

import java.util.Arrays;

/**
 *      毛毛雨     2018/11/8
 * */
public class day7_24_455分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        int num = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0,j=0;i < g.length&&j < s.length;++j){
            if (g[i] <= s[i]){
                count++;
                i++;
            }
        }
        return count;
    }
}
