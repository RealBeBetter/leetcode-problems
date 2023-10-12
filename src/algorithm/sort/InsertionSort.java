package algorithm.sort;

import java.util.Arrays;

/**
 * @author Real
 * @since 2023/6/4 18:52
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort test = new InsertionSort();
        int[] array = {1, 2, 3, 4, 8, 1, 1, 5};
        test.insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

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
