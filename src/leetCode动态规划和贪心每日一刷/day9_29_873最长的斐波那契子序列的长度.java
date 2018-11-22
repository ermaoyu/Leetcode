package leetCode动态规划和贪心每日一刷;


import java.util.HashMap;

/**
 *      毛毛雨     2018/11/11
 *      如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列
 * */
public class day9_29_873最长的斐波那契子序列的长度 {
    public int lenLongestFibSubseq(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [][] dp = new int[A.length][A.length];
        int maxLen = 0;
        int res = 2;
        for (int i = 0; i < A.length; i++) {//防止重复计算,j - i
            map.put(A[i],i);
            for (int j = i + 1; j < A.length; j++) {
                int index = map.getOrDefault(A[j] - A[i],-1);
                dp[i][j] // j - i
                        = (A[j] - A[i] < A[i] //A[index] + A[i] -> a[j]
                        && index >= 0 ) ? dp[index][i] // i - index
                        + 1 : 2 ;
                res = Math.max(res,dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }
}
