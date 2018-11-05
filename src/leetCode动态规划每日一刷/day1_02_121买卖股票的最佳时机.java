package leetCode动态规划每日一刷;

/**
 *      毛毛雨     2018/11/2
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），
 * 设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * */
public class day1_02_121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;//买入价格
        int max = 0;//最大利润
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else if (prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}
