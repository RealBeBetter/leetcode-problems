package leetcode75.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 1161. 最大层内元素和
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
 *
 * @author wei.song
 * @since 2023/6/7 21:01
 */
public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        int index = 1;
        long[] ans = new long[]{index, root.val};
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            long tempSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.removeFirst();
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                tempSum += node.val;
            }

            if (tempSum > ans[1]) {
                ans = new long[]{index, tempSum};
            }
            index++;
        }

        return (int) ans[0];
    }

}
