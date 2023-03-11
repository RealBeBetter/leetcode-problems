package plan.search;

/**
 * @author Real
 * @since 2023/3/11 15:24
 */
public class MaxAreaOfIsland {


    /**
     * 给定一个大小为 m x n 的二进制矩阵 grid，岛屿是由一些相邻的 1 (代表土地) 构成的组合。
     * 这里的「相邻」要求两个 1 必须在水平或者竖直的四个方向上相邻，假设 grid 的四个边缘都被 0（代表水）包围着。
     * 岛屿的面积是岛上值为 1 的单元格的数目，计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     *
     * @param grid 网格
     * @return int
     */
    public int maxAreaOfIsland(int[][] grid) {
        // 计算所有岛屿的面积，返回 List 集合，找出最大的数字
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        int ans = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                ans = Math.max(calcAreaOfIsland(grid, i, j), ans);
            }
        }

        return ans;
    }

    private int calcAreaOfIsland(int[][] grid, int sr, int sc) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        if (sr < 0 || sc < 0 || sr >= rowLength || sc >= columnLength || grid[sr][sc] == 0) {
            return 0;
        }

        // 避免计算重复，将计算过的格子变为 0
        grid[sr][sc] = 0;
        return calcAreaOfIsland(grid, sr + 1, sc) + calcAreaOfIsland(grid, sr - 1, sc)
                + calcAreaOfIsland(grid, sr, sc + 1) + calcAreaOfIsland(grid, sr, sc - 1) + 1;
    }


}
