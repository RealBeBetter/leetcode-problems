package problems.leet1_500;

/**
 * 74. 搜索二维矩阵
 *
 * @author Real
 * @date 2023/04/19 11:24
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 行数，多少行
        int m = matrix.length;
        // 列数，多少列，第一行多少个
        int n = matrix[0].length;
        int start = 0, mid;
        int end = m * n - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target > matrix[mid / n][mid % n]) {
                start = mid + 1;
            } else if (target < matrix[mid / n][mid % n]) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
