package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/3
 *      给定一个整数数组 nums ，
 *      找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * */
public class day2_05_152乘积最大子序列 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0 ){
            return 0;
        }
        int min = nums[0];//全局的最小值
        int max = nums[0];//全局的最大值
        int res = nums[0];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            maxIndex = max * nums[i];//连续子数组的最大值
            minIndex = min * nums[i];//连续子数组的最小值
            max = Math.max(nums[i],Math.max(maxIndex,minIndex));
            min = Math.min(nums[i],Math.min(maxIndex,minIndex));
            res = Math.max(max,res);
        }
        return res;
    }
}
