package plan.search;

/**
 * @author Real
 * @since 2023/3/11 15:12
 */
public class FloodFill {

    /**
     * 三个整数 sr, sc 和 newColor。从像素 image[sr][sc] 开始对图像进行填充。
     * 从初始像素开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点；
     * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点；
     * 重复该过程。将所有有记录的像素点的颜色值改为 newColor。
     * 使用深度优先搜索完成
     *
     * @param image 图像
     * @param sr    纵向值
     * @param sc    横向值
     * @param color 颜色
     * @return {@link int[][]}
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        recursionFill(image, oldColor, color, sr, sc);
        return image;
    }


    private void recursionFill(int[][] image, int oldColor, int newColor, int sr, int sc) {
        int rowLength = image[0].length;
        int columnLength = image.length;

        // 判断是否处于边界条件
        if (sr < 0 || sc < 0 || sr >= columnLength || sc >= rowLength || image[sr][sc] != oldColor || image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;

        // 开始向四个方向深度优先搜索
        recursionFill(image, oldColor, newColor, sr - 1, sc);
        recursionFill(image, oldColor, newColor, sr + 1, sc);
        recursionFill(image, oldColor, newColor, sr, sc - 1);
        recursionFill(image, oldColor, newColor, sr, sc + 1);
    }

}
