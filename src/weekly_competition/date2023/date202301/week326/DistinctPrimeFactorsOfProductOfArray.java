package weekly_competition.date2023.date202301.week326;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 6279. 数组乘积中的不同质因数数目
 * 给你一个正整数数组 nums ，对 nums 所有元素求积之后，找出并返回乘积中 不同质因数 的数目。
 * 注意：
 * 质数 是指大于 1 且仅能被 1 及自身整除的数字。
 * 如果 val2 / val1 是一个整数，则整数 val1 是另一个整数 val2 的一个因数。
 * <p>
 * 示例 1：
 * 输入：nums = [2,4,3,7,10,6]
 * 输出：4
 * 解释：
 * nums 中所有元素的乘积是：2 * 4 * 3 * 7 * 10 * 6 = 10080 = 25 * 32 * 5 * 7 。
 * 共有 4 个不同的质因数，所以返回 4 。
 * 示例 2：
 * 输入：nums = [2,4,8,16]
 * 输出：1
 * 解释：
 * nums 中所有元素的乘积是：2 * 4 * 8 * 16 = 1024 = 2^10 。
 * 共有 1 个不同的质因数，所以返回 1 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * 2 <= nums[i] <= 1000
 *
 * @author wei.song
 * @since 2023/1/1 18:44
 */
public class DistinctPrimeFactorsOfProductOfArray {

    /**
     * 获取不同的质因数个数
     *
     * @param nums 数字
     * @return int
     */
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        List<Integer> primes = getPrime(1000);
        for (int num : nums) {
            for (Integer prime : primes) {
                if (num % prime == 0) {
                    ans.add(prime);
                }
            }
        }
        return ans.size();
    }

    /**
     * 获取质数，是指大于 1 且仅能被 1 及自身整除的数字。
     *
     * @param n n
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> getPrime(int n) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> notPrime = new ArrayList<>(n - 1);

        for (int i = 2; i <= n; i++) {
            if (!notPrime.contains(i)) {
                ans.add(i);
                int index = 2;
                while (index * i <= n) {
                    notPrime.add(index * i);
                    index++;
                }
            }
        }
        return ans;
    }

}
