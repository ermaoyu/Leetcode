package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/9
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * */
public class day8_26_264丑数II {
    public int nthUglyNumber(int n) {
        int[] num = new int[n];
        int t2 = 0,t3 = 0,t5 = 0;
        num[0] = 1;
        for (int i = 1; i < n; i++) {
             num[i] = Math.min(num[t2]*2,Math.min(num[t3]*3,num[t5]*5));
            if (num[i] == num[t2]*2)++t2;
            if (num[i] == num[t3]*3)++t3;
            if (num[i] == num[t5]*5)++t5;
        }
        return num[n - 1];
    }
    /**
     *  给定一个数判断是否为丑数
     * */
    public boolean process(int n){
        if (n == 0)return false;
        else if (n == 1)return true;
        else if (n % 2 == 0)return process(n / 2);
        else if (n % 3 == 0)return process(n / 3);
        else if (n % 5 == 0)return process(n / 5);
        else return false;
    }
}
