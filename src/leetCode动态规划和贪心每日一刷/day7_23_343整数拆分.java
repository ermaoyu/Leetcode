package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/8
 *
 给定一个正整数 n，将其拆分为至少两个正整数的和，
 并使这些整数的乘积最大化。
 返回你可以获得的最大乘积
 * */
public class day7_23_343整数拆分 {
    public int integerBreak(int n) {
        if (n < 4) return n - 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <=n ; i++) {
            dp[i] = Math.max(2* dp[i-2],3*dp[i - 3]);
        }
        return dp[n];
    }
}
