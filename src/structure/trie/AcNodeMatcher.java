package structure.trie;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Real
 * @since 2024/6/16 19:17
 */
public class AcNodeMatcher {

    private final AcNode root;

    public AcNodeMatcher() {
        this.root = new AcNode("/");
    }

    private void insert(String pattern) {
        AcNode node = this.root;
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            String c = pattern.charAt(i) + "";
            if (Objects.isNull(node.children.get(c))) {
                node.children.put(c, new AcNode(c));
            }
            node = node.children.get(c);
        }

        node.isEndingChar = true;
        node.length = pattern.length();
    }

    private void buildFailurePointer() {
        AcNode root = this.root;
        LinkedList<AcNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            AcNode p = queue.pop();

            for (AcNode pc : p.children.values()) {
                if (Objects.isNull(pc)) {
                    continue;
                }

                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (Objects.nonNull(q)) {
                        AcNode qc = q.children.get(pc.data);
                        if (Objects.nonNull(qc)) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (Objects.isNull(q)) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    private Boolean match(String text) {
        AcNode root = this.root;
        AcNode p = root;

        int n = text.length();
        for (int i = 0; i < n; i++) {
            String c = text.charAt(i) + "";
            while (Objects.isNull(p.children.get(c)) && p != root) {
                p = p.fail;
            }

            p = p.children.get(c);
            if (Objects.isNull(p)) {
                p = root;
            }

            AcNode tmp = p;
            while (tmp != root) {
                if (tmp.isEndingChar) {
                    System.out.println("Start from " + (i - p.length + 1));
                    return true;
                }
                tmp = tmp.fail;
            }
        }

        return false;
    }

    public static boolean match(String text, String[] patterns) {
        AcNodeMatcher matcher = new AcNodeMatcher();
        for (String pattern : patterns) {
            matcher.insert(pattern);
        }

        matcher.buildFailurePointer();
        return matcher.match(text);
    }
}
