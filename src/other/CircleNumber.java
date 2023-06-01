package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wei.song
 * @since 2023/6/1 16:08
 */
public class CircleNumber {

    public static void main(String[] args) {
        CircleNumber circleNumber = new CircleNumber();
        System.out.println(circleNumber.getLastNumber(3));
        System.out.println(circleNumber.getLastNumber(2));
    }

    private int getLastNumber(int source) {
        int index = 0;
        int[] array = new int[source];
        for (int i = 1; i <= source; i++) {
            array[index++] = i;
        }

        int[] nextArray = getNextArray(array, 1);
        return nextArray[nextArray.length - 1];
    }


    private int[] getNextArray(int[] array, int start) {
        if (array.length <= 1) {
            return array;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < array.length + start; i++) {
            // 可以被 3 整除或者包含 3 的就淘汰
            if (i % 3 == 0 || String.valueOf(i).contains("3")) {
                continue;
            }
            list.add(i);
        }

        int[] nextArray = list.stream().mapToInt(Integer::intValue).toArray();
        return getNextArray(nextArray, array.length + start);
    }

}
