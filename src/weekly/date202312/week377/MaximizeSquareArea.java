package weekly.date202312.week377;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/maximum-square-area-by-removing-fences-from-a-field/">...</a>
 *
 * @author wei.song
 * @since 2023/12/24 14:34
 */
public class MaximizeSquareArea {

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> distances1 = findPossibleLength(hFences, m);
        Set<Integer> distances2 = findPossibleLength(vFences, n);

        int maxEdge = -1;
        for (Integer i : distances1) {
            if (distances2.contains(i)) {
                maxEdge = Math.max(maxEdge, i);
            }
        }

        if (maxEdge == -1) {
            return -1;
        }
        return (int) (((long) maxEdge * maxEdge) % (1_000_000_000 + 7));
    }


    public Set<Integer> findPossibleLength(int[] fences, int length) {
        List<Integer> fenceList = Arrays.stream(fences).boxed().sorted().collect(Collectors.toList());
        fenceList.add(1);
        fenceList.add(length);
        fenceList.sort(Comparator.naturalOrder());

        Set<Integer> distances = new HashSet<>();
        int size = fenceList.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                distances.add(fenceList.get(j) - fenceList.get(i));
            }
        }
        distances.add(length - 1);

        return distances;
    }

}
