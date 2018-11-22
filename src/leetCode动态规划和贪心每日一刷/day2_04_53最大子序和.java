package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/3
 *      给定一个整数数组 nums ，找到一个具有最大和的连续子数组
 *      （子数组最少包含一个元素），返回其最大和。
 * */
class day2_01_53最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0 ){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp < 0){
                tmp = nums[i];
            }else {
                tmp += nums[i];
            }
            res = Math.max(res,tmp);
        }
        return res;
    }
}
