package weekly_competition.data2023_02.week331;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 6348. 从数量最多的堆取走礼物
 * 给你一个整数数组 gifts ，表示各堆礼物的数量。每一秒，你需要执行以下操作：
 * <p>
 * 选择礼物数量最多的那一堆。
 * 如果不止一堆都符合礼物数量最多，从中选择任一堆即可。
 * 选中的那一堆留下平方根数量的礼物（向下取整），取走其他的礼物。
 * 返回在 k 秒后剩下的礼物数量。
 * <p>
 * 示例 1：
 * 输入：gifts = [25,64,9,4,100], k = 4
 * 输出：29
 * 解释：
 * 按下述方式取走礼物：
 * - 在第一秒，选中最后一堆，剩下 10 个礼物。
 * - 接着第二秒选中第二堆礼物，剩下 8 个礼物。
 * - 然后选中第一堆礼物，剩下 5 个礼物。
 * - 最后，再次选中最后一堆礼物，剩下 3 个礼物。
 * 最后剩下的礼物数量分别是 [5,8,9,4,3] ，所以，剩下礼物的总数量是 29 。
 * <p>
 * 示例 2：
 * 输入：gifts = [1,1,1,1], k = 4
 * 输出：4
 * 解释：
 * 在本例中，不管选中哪一堆礼物，都必须剩下 1 个礼物。
 * 也就是说，你无法获取任一堆中的礼物。
 * 所以，剩下礼物的总数量是 4 。
 * <p>
 * 提示：
 * <p>
 * 1 <= gifts.length <= 103
 * 1 <= gifts[i] <= 109
 * 1 <= k <= 103
 *
 * @author wei.song
 * @since 2023/2/5 12:33
 */
public class PickGifts {

    public static void main(String[] args) {
        PickGifts test = new PickGifts();
        int[] array = {25, 64, 9, 4, 100};
        System.out.println(test.pickGifts(array, 4));
    }

    /**
     * 挑选礼物，需要维护最大值，使用大顶堆
     *
     * @param gifts 礼物
     * @param k     次数
     * @return long 剩余礼物的数量之和
     */
    public long pickGifts(int[] gifts, int k) {
        if (gifts == null || gifts.length == 0) {
            return 0;
        }

        List<Integer> giftList = Arrays.stream(gifts).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> priority = new PriorityQueue<>((o1, o2) -> o2 - o1);
        priority.addAll(giftList);

        for (int i = 0; i < k; i++) {
            int currentMax = priority.peek() == null ? 0 : priority.poll();
            Integer afterPick = (int) Math.sqrt(currentMax);
            priority.add(afterPick);
        }

        return priority.stream().map(Long::valueOf).reduce(Long::sum).orElse(0L);
    }

}
