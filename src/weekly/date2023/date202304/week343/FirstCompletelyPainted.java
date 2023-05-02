package weekly.date2023.date202304.week343;

import java.util.HashMap;
import java.util.Map;

/**
 * 6342. 找出叠涂元素
 *
 * @author wei.song
 * @since 2023/4/30 10:49
 */
public class FirstCompletelyPainted {

    public static void main(String[] args) {
        FirstCompletelyPainted test = new FirstCompletelyPainted();
        int[] array = {1, 4, 5, 2, 6, 3};
        int[][] mat = {{4, 3, 5}, {1, 2, 6}};
        System.out.println(test.firstCompleteIndex(array, mat));
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rowCount = mat.length;
        int columnCount = mat[0].length;
        Map<Integer, int[]> numberIndexMap = new HashMap<>((int) (rowCount * columnCount / 0.75 + 1));

        // 获取单行或者单列最先被填满的数组中的下标位置
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                int num = mat[i][j];
                numberIndexMap.put(num, new int[]{i, j});
            }
        }

        Map<Integer, Integer> rows = new HashMap<>((int) (rowCount / 0.75 + 1));
        Map<Integer, Integer> columns = new HashMap<>((int) (columnCount / 0.75 + 1));
        for (int i = 0; i < arr.length; i++) {
            int[] positions = numberIndexMap.get(arr[i]);
            int row = positions[0];
            int column = positions[1];
            rows.put(row, rows.getOrDefault(row, 0) + 1);
            columns.put(column, columns.getOrDefault(column, 0) + 1);

            // 这里需要反过来
            if (rows.get(row) == columnCount || columns.get(column) == rowCount) {
                return i;
            }
        }

        return -1;
    }

}
