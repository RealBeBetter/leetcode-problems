package structure.tree;

import common.TreeNode;

/**
 * @author Real
 * @since 2023/4/15 14:21
 */
public class PrintBinaryTree {

    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public void midOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        midOrder(treeNode.left);
        System.out.println(treeNode.val);
        midOrder(treeNode.right);
    }

    public void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.val);
    }

}
