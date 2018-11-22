
package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/9
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * */
public class day7_25_135分发糖果 {
    public int candy(int[] ratings) {
        if (ratings.length == 1){
            return 1;
        }
        int [] left = new int[ratings.length];
        int [] right = new int[ratings.length];
        left[0] = 1;
        right[ratings.length -1] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }else {
                left[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i++) {
            if (ratings[i] > ratings[i+1]){
                right[i] = right[i + 1] + 1;
            }else {
                right[i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < ratings.length; i--) {
            res += left[i] > right[i]? left[i] : right[i];
        }
        return res;
    }
}
