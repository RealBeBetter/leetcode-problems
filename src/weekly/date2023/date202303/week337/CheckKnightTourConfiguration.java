package weekly.date2023.date202303.week337;

import java.util.ArrayList;
import java.util.List;

/**
 * 6322. 检查骑士巡视方案
 *
 * @author Real
 * @since 2023/3/19 10:50
 */
public class CheckKnightTourConfiguration {

    public static void main(String[] args) {
        CheckKnightTourConfiguration test = new CheckKnightTourConfiguration();
        int[][] grid = {{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}};
        System.out.println(test.checkValidGrid(grid));
    }

    /**
     * 检查有效巡检方案，路径为目字格
     *
     * @param grid 网格
     * @return boolean
     */
    public boolean checkValidGrid(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return false;
        }

        List<Integer> checkedGrid = new ArrayList<>();
        recursionGrid(0, 0, grid, checkedGrid);
        return checkedGrid.size() == grid.length * grid[0].length;
    }


    private void recursionGrid(int sr, int sc, int[][] grid, List<Integer> checkedGrid) {
        int columnLength = grid[0].length;
        int rowLength = grid.length;
        int totalCount = columnLength * rowLength;
        if (sr < 0 || sc < 0 || sr >= rowLength || sc >= columnLength || checkedGrid.size() == totalCount) {
            return;
        }

        // 走目字格，判断是否存在下一步满足条件
        int currentNumber = grid[sr][sc];
        checkedGrid.add(currentNumber);
        // 一次有八种走法
        int[] nextStep = getNextStep(sr, sc, grid);
        if (nextStep == null) {
            return;
        }
        recursionGrid(nextStep[0], nextStep[1], grid, checkedGrid);
    }

    private int[] getNextStep(int sr, int sc, int[][] grid) {
        int sr1 = sr + 2;
        int sr2 = sr + 1;
        int sr3 = sr - 1;
        int sr4 = sr - 2;

        int sc1 = sc - 2;
        int sc2 = sc - 1;
        int sc3 = sc + 1;
        int sc4 = sc + 2;

        int currentNumber = grid[sr][sc];
        if (checkNextStep(sr1, sc2, currentNumber, grid)) {
            return new int[]{sr1, sc2};
        } else if (checkNextStep(sr1, sc3, currentNumber, grid)) {
            return new int[]{sr1, sc3};
        } else if (checkNextStep(sr2, sc1, currentNumber, grid)) {
            return new int[]{sr2, sc1};
        } else if (checkNextStep(sr2, sc4, currentNumber, grid)) {
            return new int[]{sr2, sc4};
        } else if (checkNextStep(sr3, sc1, currentNumber, grid)) {
            return new int[]{sr3, sc1};
        } else if (checkNextStep(sr3, sc4, currentNumber, grid)) {
            return new int[]{sr3, sc4};
        } else if (checkNextStep(sr4, sc2, currentNumber, grid)) {
            return new int[]{sr4, sc2};
        } else if (checkNextStep(sr4, sc3, currentNumber, grid)) {
            return new int[]{sr4, sc3};
        } else {
            return null;
        }
    }

    private boolean checkNextStep(int sr, int sc, int currentNumber, int[][] grid) {
        int columnLength = grid[0].length;
        int rowLength = grid.length;
        if (sr < rowLength && sc < columnLength && sr >= 0 && sc >= 0) {
            return grid[sr][sc] == currentNumber + 1;
        }
        return false;
    }
}
