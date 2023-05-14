package weekly.date202305.week345;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6430. 找出转圈游戏输家
 *
 * @author Real
 * @since 2023/5/14 10:41
 */
public class CircularGame {

    public static void main(String[] args) {
        CircularGame test = new CircularGame();
        int[] ints = test.circularGameLosers(5, 2);
        int[] ints2 = test.circularGameLosers(1, 1);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }

    public int[] circularGameLosers(int n, int k) {
        List<Integer> ownBalls = new ArrayList<>();

        int temp = 1;
        int circular = 1;
        ownBalls.add(temp);
        while (true) {
            int nextStep = temp + circular * k;
            while (nextStep > n) {
                nextStep -= n;
            }
            temp = nextStep;

            circular++;
            if (ownBalls.contains(temp)) {
                break;
            } else {
                ownBalls.add(temp);
            }
        }

        int[] ans = new int[n - ownBalls.size()];
        int point = 0;
        for (int i = 1; i <= n; i++) {
            if (ownBalls.contains(i)) {
                continue;
            }
            ans[point++] = i;
        }

        return ans;
    }

}
