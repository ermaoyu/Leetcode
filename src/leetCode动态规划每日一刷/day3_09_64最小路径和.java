package leetCode动态规划每日一刷;

/**
 *      毛毛雨     2018/11/4
 *      给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，
 *      使得路径上的数字总和为最小。
 * */
public class day3_09_64最小路径和 {

    //时间复杂度为O(N * M),空间复杂度为O(N * M)
    //可以优化成空间复杂度为O(N)
    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid == null){
            return 0;
        }
        if (grid.length == 1 && grid[0].length == 1){
            return grid[0][0];
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0;i < grid.length;i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0){
                    if (i == 0 && j == 0) dp[i][j] = grid[0][0];
                    else if (i == 0)dp[0][j] = dp[0][j - 1] + grid[0][j];
                    else dp[i][0] = grid[i][0] + dp[i - 1][0];
                }else{
                    dp[i][j] = Math.min(dp[i][j - 1],dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] a= {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(a));
    }

}
