package leetcode75.tree;

import common.TreeNode;

/**
 * 1372. 二叉树中的最长交错路径
 * https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree
 *
 * @author wei.song
 * @since 2023/6/7 14:59
 */
public class LongestZigZagPath {

    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left, 1, true), dfs(root.right, 1, false)) - 1;
    }

    private int dfs(TreeNode root, int num, boolean left) {
        if (root == null) {
            return num;
        }

        if (left) {
            return Math.max(dfs(root.left, 1, true), dfs(root.right, num + 1, false));
        }

        return Math.max(dfs(root.left, num + 1, true), dfs(root.right, 1, false));
    }
}
