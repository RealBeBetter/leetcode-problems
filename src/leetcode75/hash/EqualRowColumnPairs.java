package leetcode75.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2352. 相等行列对
 *
 * @author wei.song
 * @since 2023/4/29 21:32
 */
public class EqualRowColumnPairs {

    public static void main(String[] args) {
        EqualRowColumnPairs test = new EqualRowColumnPairs();
        int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(test.equalPairs(grid));
    }

    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowMap = new HashMap<>((int) (grid[0].length / 0.75 + 1));
        Map<String, Integer> columnMap = new HashMap<>((int) (grid.length / 0.75 + 1));

        for (int[] row : grid) {
            int[] tempRow = new int[grid[0].length];
            System.arraycopy(row, 0, tempRow, 0, grid[0].length);
            rowMap.compute(Arrays.toString(tempRow), (k, v) -> v = v == null ? 1 : v + 1);
        }

        for (int i = 0; i < grid[0].length; i++) {
            int[] tempColumn = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                tempColumn[j] = grid[j][i];
            }
            columnMap.compute(Arrays.toString(tempColumn), (k, v) -> v = v == null ? 1 : v + 1);
        }

        int ans = 0;
        Set<String> keys = rowMap.keySet();
        for (String key : keys) {
            if (columnMap.containsKey(key)) {
                Integer column = columnMap.get(key);
                Integer row = rowMap.get(key);
                ans += row * column;
            }
        }

        return ans;
    }

}
