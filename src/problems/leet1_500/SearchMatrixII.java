package problems.leet1_500;

/**
 * 240. 搜索二维矩阵 II
 *
 * @author Real
 * @since 2021/11/28 17:13
 */
public class SearchMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {
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
