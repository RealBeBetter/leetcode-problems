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

    public static void main(String[] args) {
        Dota2Senate dota = new Dota2Senate();
        System.out.println(dota.predictPartyVictory("RD"));
        System.out.println(dota.predictPartyVictory("RDD"));
    }


    /**
     * 预测一方胜利
     * 关键因素：判断对方是否需要跳过。移除元素时，index 不需要变化。
     *
     * @param senate 参议院名单
     * @return {@link String}
     */
    public String predictPartyVictory(String senate) {
        String dire = "Dire";
        String radiant = "Radiant";

        int dSkipCount = 0;
        int rSkipCount = 0;

        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            queue.add(c);
        }

        Character direSymbol = dire.charAt(0);
        int point = 0;
        while (!queue.isEmpty() && !isSameParty(queue)) {
            if (point == queue.size()) {
                point = 0;
            }
            Character element = queue.get(point);
            if (direSymbol.equals(element)) {
                if (dSkipCount == 0) {
                    rSkipCount++;
                    point++;
                } else {
                    queue.remove(point);
                    dSkipCount--;
                }
            } else {
                if (rSkipCount == 0) {
                    dSkipCount++;
                    point++;
                } else {
                    queue.remove(point);
                    rSkipCount--;
                }
            }
        }

        if (direSymbol.equals(queue.peek())) {
            return dire;
        }
        return radiant;
    }

    private boolean isSameParty(Queue<Character> queue) {
        if (queue == null || queue.isEmpty()) {
            return false;
        }

        Character first = queue.peek();
        for (Character character : queue) {
            if (!character.equals(first)) {
                return false;
            }
        }
        return true;
    }
}
