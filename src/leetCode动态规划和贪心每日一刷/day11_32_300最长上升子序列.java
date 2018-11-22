package leetCode动态规划和贪心每日一刷;

/**
 *  毛毛雨     2018/11/17
 *  给定一个无序的整数数组，找到其中最长上升子序列的长度
 *  输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * */
public class day11_32_300最长上升子序列 {
    //O(N^2)
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null)return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && max < dp[j]) max = dp[j];
            }
            dp[i] = max + 1;
            if (res < dp[i]) res = dp[i];
        }
        return res;
    }

    //O(NlogN)
    //https://blog.csdn.net/OneDeveloper/article/details/80047289
    public int lengthOfLIS2(int[] nums){
        return 0;
    }
}
