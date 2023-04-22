package leetcode75.str;

/**
 * 605. 种花问题
 *
 * @author Real
 * @since 2023/4/21 23:55
 */
public class CanPlaceFlowers {

    /**
     * 可以种植的数量：在数组两端加上 0，每三个 0 可以种一朵
     *
     * @param flowerbed 花圃
     * @param n         n
     * @return boolean
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        int zeros = 1;

        for (int flower : flowerbed) {
            if (flower == 0) {
                zeros++;
                continue;
            }

            int count = zeros - 2;
            if (count > 0) {
                int plant = count % 2 == 0 ? count / 2 : (count + 1) / 2;
                ans += plant;
            }
            zeros = 0;
        }

        zeros++;
        int count = zeros - 2;
        if (count > 0) {
            int plant = count % 2 == 0 ? count / 2 : (count + 1) / 2;
            ans += plant;
        }

        return ans >= n;
    }

}
