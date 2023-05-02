package weekly.date202304.week343;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 6342. 找出叠涂元素
 *
 * @author wei.song
 * @since 2023/4/30 10:49
 */
public class FirstCompletelyPainted {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> columns = new ArrayList<>();

        for (int[] row : mat) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < n; j++) {
                temp.add(row[j]);
            }
            rows.add(temp);
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> column = new HashSet<>();
            for (int j = 0; j < m; j++) {
                column.add(mat[j][i]);
            }
            columns.add(column);
        }

        // 保存暂时需要的数据
        for (int i = 0; i < arr.length; i++) {
            Integer number = arr[i];

            for (Set<Integer> row : rows) {
                boolean remove = row.remove(number);
                if (row.isEmpty()) {
                    return i;
                }
                if (remove) {
                    break;
                }
            }

            for (Set<Integer> column : columns) {
                boolean remove = column.remove(number);
                if (column.isEmpty()) {
                    return i;
                }
                if (remove) {
                    break;
                }
            }
        }

        return -1;
    }

}
