package leetCode动态规划每日一刷;

/**
 *      毛毛雨     2018/11/3
 * 给定一个正整数数组 nums。
 * 找出该数组内乘积小于 k 的连续的子数组的个数
 * */
public class day2_06_713乘积小于K的子数组 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length == 0|| nums == null){
            return 0;
        }
        if ( k <= 1){
            return 0;
        }
        int R = 0;
        int L = 0;
        long max = 1;
        int res = 0;
        for ( R = 0; R < nums.length; R++) {
            max *= nums[R];
            while (R >= L &&  max >= k){
                max /= nums[L++];
            }
            res += R - L + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(a,100));

    }
}
