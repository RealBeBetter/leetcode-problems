package leetcode75.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 *
 * @author Real
 * @since 2023/4/21 23:37
 */
public class KidsWithGreatestNumberCandies {

    /**
     * 拥有糖果的孩子
     *
     * @param candies      糖果
     * @param extraCandies 额外糖果
     * @return {@link List}<{@link Boolean}>
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = Arrays.stream(candies).max().orElse(candies[0]);

        List<Boolean> ans = new ArrayList<>();
        for (int candy : candies) {
            boolean current = candy + extraCandies >= maxCandy;
            ans.add(current);
        }

        return ans;
    }

}
