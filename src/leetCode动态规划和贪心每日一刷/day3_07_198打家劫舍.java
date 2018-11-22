package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/4
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * */
public class day3_07_198打家劫舍 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max((res[i-2] + nums[i]),res[i - 1]);
        }
        return res[nums.length - 1];
    }
}
