package algorithm.sort;

import java.util.Arrays;

/**
 * @author wei.song
 * @since 2023/3/30 14:38
 */
public class QuickSortHard {

    public static void main(String[] args) {
        QuickSortHard test = new QuickSortHard();
        int[] array = {1, 2, 3, 4, 8, 1, 1, 5};
        test.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int low = left;
            int high = right;

            int pivot = array[left];
            while (low < high) {
                // 从右边往左边找一个小于pivot的数
                while (low < high && array[high] >= pivot) {
                    high--;
                }
                array[low] = array[high];
                // 从左边往右边找一个大于pivot的数
                while (low < high && array[low] <= pivot) {
                    low++;
                }
                array[high] = array[low];
            }

            array[low] = pivot;
            quickSort(array, left, low - 1);
            quickSort(array, low + 1, right);
        }
    }

}
