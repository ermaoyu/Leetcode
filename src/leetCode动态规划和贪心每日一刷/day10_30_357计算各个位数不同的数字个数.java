package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/14
    给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * */
public class day10_30_357计算各个位数不同的数字个数 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)return 1;
        int res = 10;
        int count = 9;
        for (int i = 1; i < n; i++) {
            res += count * (10 - i);
            count *= (10 - i);
        }
        return res ;
    }
}
