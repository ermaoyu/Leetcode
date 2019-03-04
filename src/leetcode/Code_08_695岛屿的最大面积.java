package leetcode;

/**
 *      毛毛雨     2018/11/29
 *      给定一个包含了一些 0 和 1的非空二维数组 grid ,
 *      一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 *      你可以假设二维矩阵的四个边缘都被水包围着。
 * */
public class Code_08_695岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)return 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if (1 == grid[i][j]){
                    int index = merge(grid,i,j);
                    max = Math.max(index,max);
                }
            }
        }
        return max;
    }

    public int merge(int[][] grid,int i,int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)return 0;
        if (grid[i][j] == 0)return 0;

        grid[i][j] = 0;//避免重复计算
        int sum = 1 + merge(grid,i + 1,j)
                + merge(grid,i - 1,j)
                + merge(grid,i,j - 1)
                + merge(grid,i,j + 1);
        return  sum;
    }
}
