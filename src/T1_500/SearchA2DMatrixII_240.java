package T1_500;

/**
 * @author : Real
 * @date : 2021/11/28 17:13
 * @description : 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],
 * [10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],
 * [10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109<= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109<= target <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2DMatrixII_240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;
        for (int[] ints : matrix) {
            boolean contains = binarySearch(ints, target);
            if (contains) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找目标值
     *
     * @param array  排序数组
     * @param target 目标值
     * @return 存在与否
     */
    public static boolean binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int pivot = (right - left) / 2 + left;
            if (target > array[pivot]) {
                left = pivot + 1;
            } else if (target < array[pivot]) {
                right = pivot - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {0, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        //int target = 20;
        int target = 20;
        System.out.println(searchMatrix(matrix, target));

        int[] array = {2, 5, 8, 12, 19};
        System.out.println(binarySearch(array, 5));
    }

}
