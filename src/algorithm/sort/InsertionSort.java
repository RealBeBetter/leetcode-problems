package algorithm.sort;

/**
 * @author Real
 * @since 2023/6/4 18:52
 */
public class InsertionSort {

    /**
     * 插入排序
     *
     * @param array 数组
     */
    public void insertionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (array[j] > value) {
                    // 数据移动
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j + 1] = value;
        }

    }

}
