package leetcode.Easy;

import java.util.HashMap;

public class Code_001_1两数之和 {
    /**
     *
     给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

     你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     * */
    public static  int[] twosum(int[] nums , int target){
        if (nums == null || nums.length < 2){
            return  new int[]{-1,-1};
        }
        int[] rs = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if (map.containsKey(target - nums[i])){
                rs[0] = map.get(target - nums[i]);
                rs[1] = i;
            }
            map.put(nums[i],i);
        }
        return rs;
     }

    public static  int[] twosum_2(int[] nums , int target) {
        if (nums == null || nums.length < 2){
            return  new int[]{-1,-1};
        }
        int[] rs  = new int[2];
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        int tmp = 0;
        while (i < j){
            tmp = nums[i] + nums[j];
            if (tmp == target){
                rs[0] = i;
                rs[1] = j;
                break;
            }else if (tmp > target){
                j += (i-j)/2;
            }else {
                i = j + (i - j)/2;
            }
        }
        return rs;
    }
}
