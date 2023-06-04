package algorithm.sort;

/**
 * @author Real
 * @since 2023/6/4 18:36
 */
public class BubbleSort {

    /**
     * 冒泡排序，array 表示数组
     *
     * @param array 数组
     */
    public void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;
        for (int i = 0; i < length; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < length - i - 1; ++j) {
                // 交换
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            if (!flag) {
                // 没有数据交换，提前退出
                break;
            }
        }
    }

}
