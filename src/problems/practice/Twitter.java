package problems.practice;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/design-twitter/">...</a>
 *
 * @author wei.song
 * @since 2023/8/27 10:02
 */
public class Twitter {

    private Map<Integer, TextNode> userTextListMap;

    private Map<Integer, Set<Integer>> userFollowsMap;

    private PriorityQueue<TextNode> textQueue;

    public static class TextNode {
        private final int id;
        private String content;
        private TextNode next;
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
        userFollowsMap = new HashMap<>();
        textQueue = new PriorityQueue<>(Comparator.comparing(TextNode::getTimestamp, Comparator.reverseOrder()));
    }

    public void postTweet(int userId, int tweetId) {

    }

    public List<Integer> getNewsFeed(int userId) {
        return Collections.emptyList();
    }

    public void follow(int followerId, int followeeId) {

    }

    public void unfollow(int followerId, int followeeId) {

    }

}
