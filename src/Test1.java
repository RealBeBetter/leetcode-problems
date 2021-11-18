import T1_500.IntegerReplacement_397;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @ author : Real
 * @ date : 2021/11/12 15:25
 * @ description : 连续子串相加最大的和
 * [5，3，-10，2，-1，6，8]
 * 输出：15
 */
public class Test1 {
    public static int getMaxCount(int[] array) {
        // 连续子串相加最大的和
        if (array.length == 0) {
            return 0;
        }
        int[] temp = new int[array.length + 1];


        int[] tempArray = new int[array.length * array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            tempArray[count++] = array[i];
            for (int j = i + 1; j < array.length; j++) {
                for (int k = i; k <= j; k++) {
                    tempArray[count] += array[k];
                }
                count++;
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i : tempArray) {
            if (i > ans) {
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, -10, 2, -1, 6, 8};
        int maxCount = getMaxCount(array);
        System.out.println(maxCount);
    }
}
