package leetCode动态规划每日一刷;

/**
 *      毛毛雨     2018/11/4
 * 你可以选择从索引为 0 或 1 的元素作为初始阶梯
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * */
public class day3_8_746使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0){
            return 0;
        }
        if (cost.length == 1){
            return cost[0];
        }
        if (cost.length == 2){
            return Math.min(cost[0],cost[1]);
        }
        int[] res = new int[cost.length ];
        res[0] = cost[0];
        res[1] = Math.min(cost[0],cost[1]);
        for (int i = 0; i < cost.length; i++) {
            res[i] = Math.min(res[i - 2]+cost[i],res[i -1 ] + cost[i]);
        }
        return res[cost.length - 1];
    }
}
