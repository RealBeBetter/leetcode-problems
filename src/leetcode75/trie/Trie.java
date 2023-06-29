package leetcode75.trie;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode.cn/problems/implement-trie-prefix-tree
 *
 * @author wei.song
 * @since 2023/6/29 16:58
 */
public class Trie {

    private boolean isEnd;
    private Map<Character, Trie> children;

    private Trie root;

    public Trie() {
        this.root = new Trie('/');
        this.isEnd = false;
        this.children = Collections.emptyMap();
    }

    public Trie(char node) {
        this.children = Collections.emptyMap();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        Trie temp = root;
        char[] words = word.toCharArray();
        for (char c : words) {
            Map<Character, Trie> children = temp.children;
            if (children.isEmpty()) {
                children = new HashMap<>(2);
            }

            if (!children.containsKey(c)) {
                Trie trie = new Trie(c);
                children.put(c, trie);
                temp.children = children;
            }

            temp = children.get(c);
        }

        temp.isEnd = true;
    }

    public boolean search(String word) {
        Trie temp = getLastTrie(word);
        if (temp == null) {
            return false;
        }

        return temp.isEnd;
    }

    private Trie getLastTrie(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }

        Trie temp = root;

        char[] words = word.toCharArray();
        for (char c : words) {
            Map<Character, Trie> children = temp.children;
            if (!children.containsKey(c)) {
                return null;
            }

            temp = children.get(c);
        }
        return temp;
    }

    public boolean startsWith(String prefix) {
        Trie lastTrie = getLastTrie(prefix);

        return lastTrie != null;
    }

}
