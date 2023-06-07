package leetcode75.tree;

import common.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode.cn/problems/search-in-a-binary-search-tree
 *
 * @author wei.song
 * @since 2023/6/7 15:34
 */
public class SearchBinarySearchTree {

    /**
     * 搜索bst，找到节点值等于 val 的节点。返回以该节点为根的子树；如果节点不存在，则返回 null
     *
     * @param root 根节点
     * @param val  目标值
     * @return {@link TreeNode}
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

}
