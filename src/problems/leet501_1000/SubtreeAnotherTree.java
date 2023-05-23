package problems.leet501_1000;

import common.TreeNode;

/**
 * 572. 另一棵树的子树
 *
 * @author wei.song
 * @since 2023/5/23 18:51
 */
public class SubtreeAnotherTree {

    /**
     * 一棵树是否为另一棵树的子树
     *
     * @param root    根节点
     * @param subRoot 子树根节点
     * @return boolean
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        } else {
            return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else {
            return a.val == b.val && isSame(a.left, b.left) && isSame(a.right, b.right);
        }
    }

}
