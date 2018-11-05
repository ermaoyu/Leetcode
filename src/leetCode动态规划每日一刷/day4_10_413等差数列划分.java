package leetCode动态规划每日一刷;

/**
 *      毛毛雨     2018/11/5
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，以下数列为等差数列:
 * */
public class day4_10_413等差数列划分 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)return 0;
        int sum = 0;
        int L = 0;
        int tmp = A[1]-A[0];
        for (int R = 2; R < A.length; R++) {
            while(tmp != (A[R]-A[R-1]) && R >=L) {
                tmp = (A[R]-A[R-1]);
                L = R - 1;
                break;
            }
            tmp = A[R]-A[R-1];
            if(R - L >= 2) {
                sum += R - L-2+1;
            }
        }
        return sum;
    }
}
