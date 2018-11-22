package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/6
 *
 * */
public class day5_15_122买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null)return 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
