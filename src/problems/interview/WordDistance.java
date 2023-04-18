package problems.interview;

import java.util.*;

/**
 * 面试题 17.11. 单词距离
 *
 * @author wei.song
 * @since 2023/4/18 18:43
 */
public class WordDistance {

    public int findClosest(String[] words, String word1, String word2) {
        if (words == null || words.length < 2 || Objects.equals(word1, word2)) {
            return 0;
        }

        Map<String, List<Integer>> wordMap = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++) {
            if (wordMap.containsKey(words[i])) {
                wordMap.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                wordMap.put(words[i], list);
            }
        }

        if (!wordMap.containsKey(word1) || !wordMap.containsKey(word2)) {
            return -1;
        }

        List<Integer> wordIndex1 = wordMap.get(word1);
        List<Integer> wordIndex2 = wordMap.get(word2);

        int minDistance = Integer.MAX_VALUE;

        for (Integer value : wordIndex1) {
            for (Integer integer : wordIndex2) {
                int distance = Math.abs(value - integer);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }


    /**
     * 贪心算法
     *
     * @param words 单词
     * @param word1 word1
     * @param word2 word2
     * @return int
     */
    public int findClosestGreedy(String[] words, String word1, String word2) {
        if (words == null || words.length < 2 || Objects.equals(word1, word2)) {
            return 0;
        }

        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        int length = words.length;
        for (int i = 0; i < length; i++) {
            if (Objects.equals(words[i], word1)) {
                index1 = i;
            }
            if (Objects.equals(words[i], word2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }

        return minDistance;
    }

}