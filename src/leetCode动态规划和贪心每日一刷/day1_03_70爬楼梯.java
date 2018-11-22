package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/2
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * */
public class day1_03_70爬楼梯 {
    public int climbStairs(int n) {//递归
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public int climbStairs1(int n){
        int[] res = {0,1};
        if (n < 2){
            return res[n];
        }
        int sum = 0;
        int cur = 1;
        int tmp = 1;
        for (int i = 2; i <= n; i++) {
            sum = cur + tmp;
            tmp = cur;
            cur = sum;
        }
        return sum;
    }
}
