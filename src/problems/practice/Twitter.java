package problems.practice;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <a href="https://leetcode.cn/problems/design-twitter/">...</a>
 *
 * @author wei.song
 * @since 2023/8/27 10:02
 */
public class Twitter {

    /**
     * 用户文章链表Map
     */
    private final Map<Integer, TextNode> userTextListMap;

    /**
     * 用户关注列表Map
     */
    private final Map<Integer, Set<Integer>> userFolloweeMap;

    /**
     * 每个用户维护一个文章列表，最后取出Feed流的时候做多个链表的合并
     */
    private final PriorityQueue<TextNode> textPriorityQueue;

    private final AtomicLong idGenerator;

    public static class TextNode {
        private final int id;
        private String content;
        private TextNode next;
        /**
         * 时间戳，根据时间戳降序排列[等价于全局文章Id]
         */
        private Long timestamp;

        public TextNode(int id, Long timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }

        public Long getTimestamp() {
            return timestamp;
        }
    }

    public Twitter() {
        userTextListMap = new HashMap<>();
        userFolloweeMap = new HashMap<>();
        textPriorityQueue = new PriorityQueue<>(Comparator.comparing(TextNode::getTimestamp, Comparator.reverseOrder()));
        idGenerator = new AtomicLong(0);
    }

    public void postTweet(int userId, int tweetId) {
        long tweetTimeStamp = idGenerator.getAndIncrement();
        TextNode textNode = new TextNode(tweetId, tweetTimeStamp);
        if (userTextListMap.containsKey(userId)) {
            textNode.next = userTextListMap.get(userId);
        }
        userTextListMap.put(userId, textNode);
    }

    public List<Integer> getNewsFeed(int userId) {
        textPriorityQueue.clear();

        if (userTextListMap.containsKey(userId)) {
            textPriorityQueue.offer(userTextListMap.get(userId));
        }

        // 拿到自己关注的用户文章
        Set<Integer> followeeUsers = userFolloweeMap.get(userId);
        if (followeeUsers != null && !followeeUsers.isEmpty()) {
            for (Integer followeeId : followeeUsers) {
                if (userTextListMap.containsKey(followeeId)) {
                    textPriorityQueue.offer(userTextListMap.get(followeeId));
                }
            }
        }

        // 得到结果，取出最新的 10 条数据
        List<Integer> result = new ArrayList<>();
        while (!textPriorityQueue.isEmpty() && result.size() < 10) {
            TextNode textNode = textPriorityQueue.poll();
            result.add(textNode.id);
            // 维护最大堆，需要将头结点的下一个结点放入列表
            if (textNode.next != null) {
                textPriorityQueue.offer(textNode.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        userFolloweeMap.compute(followerId, (k, v) -> {
            if (v == null) {
                v = new HashSet<>();
            }
            v.add(followeeId);
            return v;
        });
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        userFolloweeMap.compute(followerId, (k, v) -> {
            if (v == null) {
                return null;
            }
            v.remove(followeeId);
            return v;
        });
    }

}
