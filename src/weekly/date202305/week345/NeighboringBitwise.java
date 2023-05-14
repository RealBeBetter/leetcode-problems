package weekly.date202305.week345;

/**
 * 6431. 相邻值的按位异或
 *
 * @author Real
 * @since 2023/5/14 11:10
 */
public class NeighboringBitwise {

    public static void main(String[] args) {
        NeighboringBitwise test = new NeighboringBitwise();
        int[] array = {1, 0};
        System.out.println(test.doesValidArrayExist(array));
    }

    public boolean doesValidArrayExist(int[] derived) {
        boolean oneStartValid = withOneStartValid(derived);
        boolean zeroStartValid = withZeroStartValid(derived);
        return oneStartValid || zeroStartValid;
    }


    private boolean withOneStartValid(int[] derived) {
        int length = derived.length;
        int[] target = new int[length];
        target[0] = 1;
        return judgeArrayValid(derived, length, target);
    }

    private boolean withZeroStartValid(int[] derived) {
        int length = derived.length;
        int[] target = new int[length];
        target[0] = 0;
        return judgeArrayValid(derived, length, target);
    }

    private boolean judgeArrayValid(int[] derived, int length, int[] target) {
        for (int i = 1; i < length; i++) {
            if (derived[i - 1] == 0) {
                target[i] = target[i - 1];
            } else {
                target[i] = target[i - 1] == 0 ? 1 : 0;
            }
        }

        if (derived[length - 1] == 0) {
            return target[length - 1] == target[0];
        }
        return target[length - 1] != target[0];
    }

}
