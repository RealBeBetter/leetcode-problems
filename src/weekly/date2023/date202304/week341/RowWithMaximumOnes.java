package weekly.date2023.date202304.week341;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 6376. 一最多的行
 *
 * @author Real
 * @since 2023/4/16 10:33
 */
public class RowWithMaximumOnes {

    public static void main(String[] args) {
        int[][] mat = {{0, 1}, {1, 0}};
        RowWithMaximumOnes test = new RowWithMaximumOnes();
        System.out.println(Arrays.toString(test.rowAndMaximumOnes(mat)));
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        TreeMap<Integer, Integer> countMap = new TreeMap<>(Comparator.reverseOrder());

        int length = mat.length;
        int eachRowLength = mat[0].length;
        for (int i = 0; i < length; i++) {
            int row = i;
            int count = 0;
            for (int j = 0; j < eachRowLength; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (!countMap.containsKey(count)) {
                countMap.put(count, row);
            }
        }

        Map.Entry<Integer, Integer> maxEntry = countMap.firstEntry();
        return new int[]{maxEntry.getValue(), maxEntry.getKey()};
    }

}
