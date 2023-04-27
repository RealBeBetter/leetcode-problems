package leetcode75.hash;

import java.util.*;

/**
 * 2215. 找出两数组的不同
 *
 * @author Real
 * @since 2023/4/27 22:47
 */
public class FindDifferenceTwoArrays {

    /**
     * 发现差异，找出在对方数组中不存在的元素
     *
     * @param nums1 nums1
     * @param nums2 nums2
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, Boolean> map1 = new HashMap<>((int) (nums1.length / 0.75 + 1));
        Map<Integer, Boolean> map2 = new HashMap<>((int) (nums2.length / 0.75 + 1));
        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
            if (i < nums1.length) {
                map1.putIfAbsent(nums1[i], Boolean.TRUE);
                i++;
            }
            if (j < nums2.length) {
                map2.putIfAbsent(nums2[j], Boolean.TRUE);
                j++;
            }
        }

        Set<Integer> differences1 = new HashSet<>();
        Set<Integer> differences2 = new HashSet<>();
        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
            if (i < nums1.length) {
                if (!map2.containsKey(nums1[i])) {
                    differences1.add(nums1[i]);
                }
                i++;
            }
            if (j < nums2.length) {
                if (!map1.containsKey(nums2[j])) {
                    differences2.add(nums2[j]);
                }
                j++;
            }
        }

        ans.add(new ArrayList<>(differences1));
        ans.add(new ArrayList<>(differences2));

        return ans;
    }

}
