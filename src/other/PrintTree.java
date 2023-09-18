package other;

import java.util.*;

/**
 * @author wei.song
 * @since 2023/6/12 23:21
 */
public class PrintTree {

    static class Node {
        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public int getParentId() {
            return this.parentId;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        List<Node> nodeList = Arrays.asList(new Node(1, 0, "AA"), new Node(2, 1, "BB"), new Node(3, 1, "CC"), new Node(4, 3, "DD"), new Node(5, 3, "EE"), new Node(6, 2, "FF"), new Node(7, 2, "GG"), new Node(8, 4, "HH"), new Node(9, 5, "II"), new Node(10, 0, "JJ"), new Node(11, 10, "KK"), new Node(12, 10, "LL"), new Node(13, 12, "MM"), new Node(14, 13, "NN"), new Node(15, 14, "OO"));
        print(nodeList);
    }

    static Map<Integer, Node> idToNodeMap = new HashMap<>();
    static Map<Integer, List<Node>> idToChildrenMap = new HashMap<>();

    static Set<Integer> isVisited = new HashSet<>();

    static StringBuilder grid = new StringBuilder();

    private static void print(List<Node> nodeList) {
        for (Node node : nodeList) {
            idToNodeMap.put(node.getId(), node);
        }
        for (Node node : nodeList) {
            int curId = node.getId();
            List<Node> curChildren = new ArrayList<>();
            for (Node childNode : nodeList) {
                if (curId == childNode.getParentId()) {
                    curChildren.add(childNode);
                }
            }
            idToChildrenMap.put(curId, curChildren);
        }

        for (Map.Entry<Integer, List<Node>> entry : idToChildrenMap.entrySet()) {
            Integer curId = entry.getKey();
            if (isVisited.contains(curId)) {
                continue;
            }
            grid = new StringBuilder();
            print(curId, 0);
        }
    }

    private static void print(Integer id, int level) {
        Node curNode = idToNodeMap.get(id);
        System.out.println(grid + curNode.getName());
        for (int i = 0; i < level; i++) {
            grid.append("  ");
        }
        StringBuilder temp = grid;
        isVisited.add(id);
        List<Node> children = idToChildrenMap.get(id);
        for (Node node : children) {
            print(node.getId(), level + 1);
            grid = temp;
        }
    }

}
