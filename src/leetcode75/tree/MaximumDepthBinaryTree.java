package leetcode75.tree;

import common.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author wei.song
 * @since 2023/5/18 10:05
 */
public class MaximumDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
