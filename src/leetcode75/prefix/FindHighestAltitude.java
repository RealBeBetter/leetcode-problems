package leetcode75.prefix;

/**
 * 1732. 找到最高海拔
 *
 * @author Real
 * @since 2023/4/27 22:32
 */
public class FindHighestAltitude {

    /**
     * 最大海拔高度，前缀和
     *
     * @param gain 经历的数组高度
     * @return int
     */
    public int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length + 1];

        int maxAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            altitudes[i + 1] = gain[i] + altitudes[i];
            maxAltitude = Math.max(maxAltitude, altitudes[i + 1]);
        }

        return maxAltitude;
    }

}
