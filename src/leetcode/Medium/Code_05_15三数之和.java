package leetcode.Medium;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * maomaoyu    2019/8/19_22:25
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 **/
public class Code_05_15三数之和 {

    /**
     *  双指针解法,0(N²)
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(nums == null || nums.length < 3){
            return res;
        }
        //快排对数组进行排序
        quickSort(nums,0,len - 1);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0 ){break;}
            if (i > 0 && nums[i] == nums[i - 1]){continue;}
            int L = i + 1;
            int R = len - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    // 去重
                    while (L<R && nums[L] ==nums[L+1]){L++;}
                    // 去重
                    while (L<R && nums[R] ==nums[L-1]){R--;}
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }

        return res;
    }

    private void quickSort(int[] nums,int L,int R) {
        if (L < R) {
            int[] p = partition(nums,L,R);
            quickSort(nums,L,p[0] - 1);
            quickSort(nums, p[1] + 1, R);
        }
    }

    private int[] partition(int[] nums, int L, int R) {
        Random r = new Random();
        int k = L + r.nextInt(R-L+1);
        int index = nums[k];
        swap(nums,k,R);
        int less = L ;
        int more= L - 1;
        while(L < R){
            if (nums[L] < index){
                swap(nums, ++more, L++);
            }else if (nums[L] > index){
                swap(nums,--more,L);
            }else {
                L++;
            }
        }
        swap(nums, ++more, R);
        return new int []{less + 1, more};
    }

    private void swap(int[] nums,int i,int j){
        /*int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;*/
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }


}
