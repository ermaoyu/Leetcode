package leetcode;

/**
 *      毛毛雨     2018/11/23
 *      给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 *      可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * */
public class Code_07_287寻找重复数 {
    //详解: https://blog.csdn.net/jmspan/article/details/51158516
    //快慢指针法,相当于链表环问题
    public int findDuplicate2(int[] nums) {
        int low = nums[0];
        int fast = nums[nums[0]];
        //找到快慢指针相遇的地方
       while(nums[low] != nums[fast]){
           low = nums[low];
           fast = nums[nums[fast]];
       }
        int res = 0;
        while (nums[res] != nums[low]){
            res = nums[res];
            low = nums[low];
        }
        return nums[res];
    }
}
