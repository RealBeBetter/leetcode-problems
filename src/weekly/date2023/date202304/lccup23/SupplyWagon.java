package weekly.date2023.date202304.lccup23;

import java.util.Arrays;

/**
 * 1. 补给马车
 *
 * @author Real
 * @since 2023/4/22 15:06
 */
public class SupplyWagon {

    public static void main(String[] args) {
        SupplyWagon test = new SupplyWagon();
        int[] array = {1, 3, 1, 5};
        System.out.println(Arrays.toString(test.supplyWagon(array)));
    }

    public int[] supplyWagon(int[] supplies) {
        int times = supplies.length / 2;
        return mergeTwoWagon(supplies, supplies.length - times);
    }


    private int[] mergeTwoWagon(int[] supplies, int times) {
        if (times <= 0) {
            return supplies;
        }

        int target = 0;
        int min = supplies[0] + supplies[1];
        int length = supplies.length;

        for (int i = 1; i < length; i++) {
            int sum = supplies[i - 1] + supplies[i];
            if (sum < min) {
                min = sum;
                target = i - 1;
            }
        }

        int[] ans = new int[length - 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (i != target) {
                ans[index++] = supplies[i];
                continue;
            }

            ans[index++] = min;
            i++;
        }
        return mergeTwoWagon(ans, --times);
    }

}
