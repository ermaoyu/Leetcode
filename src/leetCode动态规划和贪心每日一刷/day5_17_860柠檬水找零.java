package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/6
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * */
public class day5_17_860柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int[] n = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)n[0]++;
            else if (bills[i] == 10){
                if (n[0] < 1)return false;
                else {
                    n[0]--;
                    n[1]++;
                }
            }else {
                if (n[0] > 0 && n[1] >0){
                    n[0]--;
                    n[1]--;
                }else if (n[0]>3){
                    n[0] -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
