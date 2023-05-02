package leetcode75.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 649. Dota2 参议院
 *
 * @author wei.song
 * @since 2023/4/30 10:22
 */
public class Dota2Senate {


    /**
     * 预测一方胜利
     *
     * @param senate 参议院
     * @return {@link String}
     */
    public String predictPartyVictory(String senate) {
        String dire = "Dire";
        String radiant = "Radiant";

        Queue<Character> queue = new LinkedList<>();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == dire.charAt(0)) {
                queue.offer(dire.charAt(0));
            } else {
                queue.offer(radiant.charAt(0));
            }
        }

        return null;
    }

}
