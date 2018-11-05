package leetCode动态规划每日一刷;

/**
 *      毛毛雨     2018/11/2
 *      给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，
 *      包含 i,  j 两点。
 * */
public class day1_01_303区域和检索数组不可变 {
    class NumArray {
        private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        for(;i <= j;i++){
            sum += nums[i];
        }
        return sum;
    }
    }
}
