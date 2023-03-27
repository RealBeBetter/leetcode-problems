package other;

/**
 * 1299. 将每个元素替换为右侧最大元素
 *
 * @author wei.song
 * @since 2023/3/24 18:57
 */
public class ReplaceElements {

    public static void main(String[] args) {

    }

    public int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int length = arr.length;
        int[] ans = new int[length];
        for (int i = 1; i < length; i++) {
            int elementIndex = getMaxElementIndex(arr, i);
            for (int j = i - 1; j < elementIndex; j++) {
                ans[j] = arr[elementIndex];
            }
            i = elementIndex;
        }

        ans[length - 1] = -1;
        return ans;
    }

    private int getMaxElementIndex(int[] array, int start) {
        int length = array.length;
        if (start >= length) {
            return -1;
        }

        int index = start;
        for (int i = start; i < length; i++) {
            if (array[i] >= array[index]) {
                index = i;
            }
        }

        return index;
    }

}
