package weekly.date202305.week347;

import java.util.HashSet;
import java.util.Set;

/**
 * 6440. 对角线上不同值的数量差
 *
 * @author Real
 * @since 2023/5/28 11:05
 */
public class DifferenceNumberDiagonals {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] answer = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int leftTop = getLeftTop(i, j, grid);
                int rightBottom = getRightBottom(i, j, grid);
                int abs = Math.abs(leftTop - rightBottom);
                answer[i][j] = abs;
            }
        }

        return answer;
    }

    private int getLeftTop(int row, int col, int[][] grid) {
        if (row == 0 || col == 0) {
            return 0;
        }

        Set<Integer> leftTops = new HashSet<>();
        while (row > 0 && col > 0) {
            leftTops.add(grid[row - 1][col - 1]);
            row--;
            col--;
        }

        return leftTops.size();
    }

    private int getRightBottom(int row, int col, int[][] grid) {
        if (row == grid.length - 1 || col == grid[0].length - 1) {
            return 0;
        }

        Set<Integer> rightBottoms = new HashSet<>();
        while (row < grid.length - 1 && col < grid[0].length - 1) {
            rightBottoms.add(grid[row + 1][col + 1]);
            row++;
            col++;
        }

        return rightBottoms.size();
    }

}
