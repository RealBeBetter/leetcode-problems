package T1_500;

import java.util.Arrays;

/**
 * @ author : Real
 * @ date : 2021/10/28 20:55
 * @ description : 矩阵置0，73
 * 给定一个m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。
 * 请使用 原地 算法。
 *
 * 进阶：
 * 一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SetMatrixZeroes_73 {
    // 解题思路：标识出原始的0，然后再修改矩阵
    public static void setZeroes(int[][] matrix) {
        // 尝试使用数组存储 0 值的初始位置
        int count = 0;
        int[] x = new int[matrix.length * matrix[0].length];
        int[] y = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    x[count] = i;
                    y[count++] = j;
                }
            }
        }
        /*System.out.println("为0的坐标");
        for (int i = 0; i < count; i++) {
            System.out.println(x[i] + "， " + y[i]);
        }*/
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // 遍历顺序先横向，再纵向，j代表横坐标，k代表纵坐标
                for (int k = 0; k < matrix[0].length; k++) {
                    // x 代表横坐标，y代表纵坐标
                    if (j == x[i] || k == y[i]) {
                        matrix[j][k] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("改变后的矩阵：");
        int[][] matrix1 = {{1,0,1},{0,0,0},{1,0,1}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // 比较两个矩阵是否相等
        System.out.println(Arrays.deepEquals(matrix, matrix1));
    }
}
