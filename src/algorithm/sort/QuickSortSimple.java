package algorithm.sort;

import java.util.Arrays;

/**
 * @author wei.song
 * @since 2023/10/12 11:26
 */
public class QuickSortSimple {

    public static void main(String[] args) {
        QuickSortSimple sorter = new QuickSortSimple();

        // Test empty array
        int[] emptyArr = new int[]{};
        sorter.quickSort(emptyArr, 0, emptyArr.length - 1);
        // Output: []
        System.out.println(Arrays.toString(emptyArr));

        // Test single element array
        int[] singleElementArr = new int[]{1, 7};
        sorter.quickSort(singleElementArr, 0, singleElementArr.length - 1);
        // Output: [1]
        System.out.println(Arrays.toString(singleElementArr));

        // Test array with duplicate elements
        int[] duplicateElementsArr = new int[]{5, 1, 1, 2, 0, 0};
        sorter.quickSort(duplicateElementsArr, 0, duplicateElementsArr.length - 1);
        // Output: [0, 0, 1, 1, 2, 5]
        System.out.println(Arrays.toString(duplicateElementsArr));

        // Test normal array
        int[] normalArr = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        sorter.quickSort(normalArr, 0, normalArr.length - 1);
        // Output: [1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println(Arrays.toString(normalArr));
    }

    public void quickSort(int[] array, int left, int right) {
        if (array == null || array.length == 0 || left > right) {
            return;
        }

        int middle = left + (right - left) / 2;
        int pivot = array[middle];

        int i = left, j = right;

        while (i <= j) {
            while (array[i] < pivot && i <= j) {
                i++;
            }

            while (array[j] > pivot && i <= j) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }

            if (left < j) {
                quickSort(array, left, j);
            }
            if (right > i) {
                quickSort(array, i, right);
            }
        }

    }

}
