package leetCode动态规划和贪心每日一刷;

import java.util.Arrays;

/**
 *      毛毛雨     2018/11/6
 *      输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * */
public class day5_16_123买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length <= 1){
          return 0;
      }
      int buy1 = Integer.MIN_VALUE,buy2 = Integer.MIN_VALUE;
      int sell1 = 0,sell2 = 0;
        for (int i = 0; i < prices.length ; i++) {
            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(sell1,buy1 + prices[i]);
            buy2 = Math.max(buy2,sell1 - prices[i]);//第二次的价格肯定要大于第一次
            sell2 = Math.max(sell2,buy2 + prices[i]);
        }
        return sell2;
    }

}
