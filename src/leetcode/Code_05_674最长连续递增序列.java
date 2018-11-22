package leetcode;

/**
 *      毛毛雨     2018/11/11
 *      给定一个未经排序的整数数组，
 *      找到最长且连续的的递增序列。
 * */
public class Code_05_674最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        int R = 1;
        int L = 0;
        int max = Integer.MIN_VALUE;
        while(R < nums.length){
            if (nums[R] <= nums[R - 1]){
                 L = R;
                 R++;
            }else {
                max = Math.max(R - L + 1,max);//下标相减所以要加上1
                R++;
            }
        }
        return max;

    }
}
