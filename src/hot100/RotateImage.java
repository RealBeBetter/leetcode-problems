package hot100;

/**
 * 48. 旋转图像
 *
 * @author Real
 * @since 2023/4/1 11:19
 */
public class RotateImage {

    /**
     * 旋转 n*n 的数组 90°，旋转两次解决。先沿右上 - 左下的对角线翻转（270°+270° +270°+ 一次镜像），
     * 再沿水平中线上下翻转（−180°+-180° +−180°+ 一次镜像），可以实现顺时针 90 度的旋转效果
     *
     * @param matrix 矩阵
     */
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int nums = matrix.length;
        for (int i = 0; i < nums; ++i) {
            for (int j = 0; j < nums - i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - j][nums - 1 - i];
                matrix[nums - 1 - j][nums - 1 - i] = temp;
            }
        }

        for (int i = 0; i < (nums >> 1); ++i) {
            for (int j = 0; j < nums; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - i][j];
                matrix[nums - 1 - i][j] = temp;
            }
        }
    }

}
