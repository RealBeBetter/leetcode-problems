package problems.leet1_500;

/**
 * @author : Real
 * @date : 2021/12/4 9:43
 * @description : 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，
 * 是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;          // 行数，多少行
        int n = matrix[0].length;       // 列数，多少列，第一行多少个
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
