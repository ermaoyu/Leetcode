package leetCode动态规划每日一刷;

/**
 *      毛毛雨     2018/11/5
 *      给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * */
public class day4_12_96不同的二叉搜索树 {
    public int numTrees(int n) {
        if (n == 0)return 0;
        if (n == 1)return 1;
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 0;j < i;j++){
                nums[i] = nums[i] + nums[j] * nums[i - j -1];//这里i-1-j 减掉的 1 代表是根节点占了一个位置
            }
        }
        return nums[n];
    }
}
