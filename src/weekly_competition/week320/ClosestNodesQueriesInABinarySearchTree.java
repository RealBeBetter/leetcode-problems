package weekly_competition.week320;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * 返回数组 answer 。
 * <p>
 * 示例 1 :
 * 输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 * 输出：[[2,2],[4,6],[15,-1]]
 * 解释：按下面的描述找出并返回查询的答案：
 * - 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
 * - 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
 * - 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
 * <p>
 * 示例 2 ：
 * 输入：root = [4,null,9], queries = [3]
 * 输出：[[-1,4]]
 * 解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
 * <p>
 * 提示：
 * 树中节点的数目在范围 [2, 105] 内
 * 1 <= Node.val <= 106
 * n == queries.length
 * 1 <= n <= 105
 * 1 <= queries[i] <= 106
 *
 * @author Real
 * Date: 2022/11/20 10:50
 */
public class ClosestNodesQueriesInABinarySearchTree {

    public static void main(String[] args) {

    }

    /**
     * 找出小于等于的最大值，和大于等于的最小值
     * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
     * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
     *
     * @param root    根节点
     * @param queries 查询数组
     * @return 多层List，answer[i] = [mini, maxi]
     */
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> tree = new LinkedList<>();
        if (root == null || queries == null || queries.size() == 0) {
            return new ArrayList<>();
        }
        // 屏蔽默认值干扰
        int size = queries.size();
        Integer[] min = new Integer[size];
        Integer[] max = new Integer[size];
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (nodes.size() != 0) {
            TreeNode node = nodes.remove(0);
            int val = node.val;
            for (int i = 0; i < size; i++) {
                Integer target = queries.get(i);
                if (val <= target) {
                    Integer existMin = min[i];
                    if (existMin == null || existMin < val) {
                        min[i] = val;
                    }
                }
                if (val >= target) {
                    Integer existMax = max[i];
                    if (existMax == null || val < existMax) {
                        max[i] = val;
                    }
                }
            }
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        for (int i = 0; i < size; i++) {
            List<Integer> currentQuery = new ArrayList<>();
            currentQuery.add(0, min[i] == null ? -1 : min[i]);
            currentQuery.add(1, max[i] == null ? -1 : max[i]);
            tree.add(currentQuery);
        }
        return tree;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
