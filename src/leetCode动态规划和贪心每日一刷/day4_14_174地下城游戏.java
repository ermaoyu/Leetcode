package leetCode动态规划和贪心每日一刷;

/**
 *      毛毛雨     2018/11/5
 * */
public class day4_14_174地下城游戏 {
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length;//行
        int n = dungeon[0].length;//列
        int dp[][] = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1],1);
        for (int i = m - 2; i >= 0; i-- ){
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1],1);
        }
        for (int i = n - 2; i >= 0 ; i--) {
            dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i],1);
        }
        for (int i = m -2; i >= 0; i--) {//从右下角往左上角遍历
            for (int j = n - 2; j>= 0; j--) {
               int down = Math.max(dp[i + 1][j]-dungeon[i][j],1);
               int right = Math.max(dp[i][j+1]-dungeon[i][j],1);
               dp[i][j] = Math.min(right,down);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] a = {{0,0,0},{0,0,0},{0,0,-1}};
        System.out.println(calculateMinimumHP(a));
    }
}
