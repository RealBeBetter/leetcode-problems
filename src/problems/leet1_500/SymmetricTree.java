package problems.leet1_500;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 101. 对称二叉树
 *
 * @author Real
 * @since 2023/4/18 22:10
 */
public class SymmetricTree {

    /**
     * 判断二叉树是否轴对称
     *
     * @param root 根节点
     * @return boolean
     */
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root.left);
        nodes.add(root.right);
        while (!nodes.isEmpty()) {
            TreeNode left = nodes.removeFirst();
            TreeNode right = nodes.removeFirst();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            nodes.add(left.left);
            nodes.add(right.right);

            nodes.add(left.right);
            nodes.add(right.left);

        }

        return true;
    }

}
