package weekly.date202304.week339;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 6364. 老鼠和奶酪
 *
 * @author Real
 * @since 2023/4/2 11:03
 */
public class MiceAndCheese {

    public static void main(String[] args) {
        MiceAndCheese test = new MiceAndCheese();
        int[] reward1 = {1, 1, 3, 4}, reward2 = {4, 4, 1, 1};
        int k = 2;
        System.out.println(test.miceAndCheese(reward1, reward2, k));
    }

    /**
     * 老鼠和奶酪。奶酪数最多为 length，求出各取 k \ length - k 个奶酪的情况下最大收益，下标不能冲突
     *
     * @param reward1 reward1
     * @param reward2 reward2
     * @param k       k
     * @return int
     */
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int length = reward1.length;
        PriorityQueue<Integer> reward = new PriorityQueue<>(Comparator.reverseOrder());

        int ans = 0;
        for (int i = 0; i < length; i++) {
            reward.add(reward1[i] - reward2[i]);
            ans += reward2[i];
        }

        int index = 0;
        while (!reward.isEmpty() && index < k) {
            ans += reward.poll();
            index++;
        }

        return ans;
    }

}
