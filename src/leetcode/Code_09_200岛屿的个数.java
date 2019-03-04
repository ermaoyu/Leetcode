package leetcode;

/**
 *      毛毛雨     2018/11/29
 *      给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 *      一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 *      你可以假设网格的四个边均被水包围。
 * */
public class Code_09_200岛屿的个数 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)return 0;
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    num++;
                    merge(grid,i,j);
                }
            }
        }
        return num;
    }

    public void merge(char[][] grid ,int i,int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)return ;
        if (grid[i][j] == '0')return ;
        grid[i][j] = '0';//避免重复计算
        merge(grid,i + 1,j);
        merge(grid,i - 1,j);
        merge(grid,i,j - 1);
        merge(grid,i,j + 1);
        return;

    }
}
