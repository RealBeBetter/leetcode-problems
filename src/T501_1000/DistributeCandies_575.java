package T501_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author : Real
 * @ date : 2021/11/1 20:35
 * @ description : 575. 分糖果
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。
 * Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。
 * Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 * 给你一个长度为 n 的整数数组 candyType ，
 * 返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
 *
 * 示例 1：
 * 输入：candyType = [1,1,2,2,3,3]
 * 输出：3
 * 解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
 * 示例 2：
 * 输入：candyType = [1,1,2,3]
 * 输出：2
 * 解释：Alice 只能吃 4 / 2 = 2 枚糖，不管她选择吃的种类是 [1,2]、[1,3] 还是 [2,3]，她只能吃到两种不同类的糖。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistributeCandies_575 {
    public int distributeCandies(int[] candyType) {
        // 计算出糖果的种类即可
        int number = candyType.length / 2;
        int type = 0;
        // 如何去重？使用HashMap即可，最快的方法，键代表不同的糖果，值代表数量
        // 使用set应该还可以更快
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : candyType) {
            map.putIfAbsent(j, 1);
        }
        // 糖果的种类
        type = map.size();
        return Math.min(type, number);
    }
}
