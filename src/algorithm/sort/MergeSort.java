package algorithm.sort;

import java.util.Arrays;

/**
 * @author Real
 * @since 2024/1/20 11:38
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort test = new MergeSort();
        int[] array = {1, 2, 3, 4, 8, 7, 9, 5, 6};
        test.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        mergeSortRange(array, 0, array.length - 1);
    }

    public void mergeSortRange(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSortRange(array, left, mid);
        mergeSortRange(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public void merge(int[] array, int left, int mid, int right) {
        int[] results = new int[right - left + 1];

        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            results[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }

        while (p1 <= mid) {
            results[i++] = array[p1++];
        }
        while (p2 <= right) {
            results[i++] = array[p2++];
        }

        for (i = 0; i < results.length; i++) {
            array[left + i] = results[i];
        }
    }

}
