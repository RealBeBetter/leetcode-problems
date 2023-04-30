package leetcode75.queue;

import java.util.LinkedList;

/**
 * 933. 最近的请求次数
 * <p>
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 *
 * @author wei.song
 * @since 2023/4/30 09:52
 */

public class RecentCounter {

    private final LinkedList<Integer> requestQueue;

    public static final int THRESHOLD = 3000;

    public RecentCounter() {
        this.requestQueue = new LinkedList<>();
    }

    public int ping(int t) {
        this.requestQueue.add(t);
        while (!this.requestQueue.isEmpty() && this.requestQueue.getFirst() < t - THRESHOLD) {
            // 1 2 3 4 5
            this.requestQueue.removeFirst();
        }

        return requestQueue.size();
    }

}
