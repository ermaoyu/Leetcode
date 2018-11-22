package leetCode动态规划和贪心每日一刷;

/**
 * 毛毛雨     2018/11/8
 * 四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
 */
public class day7_24_279完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(dp[i - j * j] + 1, min);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
