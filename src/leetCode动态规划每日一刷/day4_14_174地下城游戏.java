package leetCode动态规划每日一刷;

/**
 *      毛毛雨     2018/11/5
 * */
public class day4_14_174地下城游戏 {
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 && dungeon[0].length == 0)return 0;
        int m = dungeon.length;//行
        int n = dungeon[0].length;//列
        int dp[][] = new int[m][n];
        for (int i = m -1; i >= 0; i--) {//从右下角往左上角遍历
            for (int j = n - 1; j>= 0; j--) {
                if (i == m -1 || j == n -1 ){
                    if (i == m -1 && j == n -1)dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : -dungeon[m - 1][n - 1];
                    else if (i == m -1)dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j],1);
                    else dp[i][j] = Math.max(dp[i + 1][j]-dungeon[i][j],1);
                }else {
                    int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                    int down = Math.max(dp[i + 1][i] - dungeon[i][j], 1);
                    dp[i][j] = Math.min(right, down);
                }
            }
        }
        return dp[0][0]+1;
    }

    public static void main(String[] args) {
        int[][] a = {{0,0,0},{0,0,0},{0,0,-1}};
        System.out.println(calculateMinimumHP(a));
    }
}
