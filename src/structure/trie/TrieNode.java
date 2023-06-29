package structure.trie;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Real
 * @since 2023/4/17 22:45
 */
public class TrieNode {

    /**
     * 根节点，存储无意义的 char 即可
     */
    private final TrieNode root = new TrieNode('/');

    private char data;

    private boolean isEndingChar;

    /**
     * 子节点，这里不使用数组进行映射，直接使用 Map
     */
    private Map<Character, TrieNode> children;


    public TrieNode() {
        this.isEndingChar = false;
        this.children = Collections.emptyMap();
    }

    public TrieNode(char data) {
        this.data = data;
        this.children = Collections.emptyMap();
    }

    public TrieNode(char data, boolean isEndingChar, Map<Character, TrieNode> children) {
        this.data = data;
        this.isEndingChar = isEndingChar;
        this.children = children;
    }

    public void buildTrie(List<String> sources) {
        for (String source : sources) {
            char[] text = source.toCharArray();
            insertData(text);
        }
    }

    public void insertData(char[] text) {
        TrieNode parent = root;
        for (char c : text) {
            Map<Character, TrieNode> children = parent.children;
            if (children == null || children.isEmpty()) {
                children = new HashMap<>(2);
            }

            // 构建新的子节点
            if (!children.containsKey(c)) {
                TrieNode newNode = new TrieNode(c);
                children.put(c, newNode);
                parent.children = children;
            }
            parent = children.get(c);
        }

        parent.isEndingChar = true;
    }


    public boolean findData(char[] pattern) {
        TrieNode trieNode = this.root;

        for (char c : pattern) {
            Map<Character, TrieNode> children = trieNode.children;
            if (!children.containsKey(c)) {
                return false;
            }

            trieNode = children.get(c);
        }

        // 查看是否能完全匹配，否则只是前缀
        return trieNode.isEndingChar;
    }
}
