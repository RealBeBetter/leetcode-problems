package structure.tree;

import common.TreeNode;

/**
 * @author Real
 * @since 2023/4/15 14:52
 */
public class BinarySearchTree {

    /**
     * 找到目标结点
     *
     * @param root 根结点
     * @param data 需要寻找的数据
     * @return {@link TreeNode}
     */
    public TreeNode findNode(TreeNode root, int data) {
        while (root != null) {
            if (root.val == data) {
                return root;
            } else if (data > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return null;
    }

    public void insertNode(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }

        TreeNode p = root;
        while (true) {
            if (data > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void deleteNode(TreeNode root, int data) {
        // node 指向要删除的节点，初始化指向根节点
        TreeNode node = root;
        // parent 记录的是 node 的父节点
        TreeNode parent = null;
        while (node != null && node.val != data) {
            parent = node;
            if (data > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (node == null) {
            // 没有找到
            return;
        }

        // 要删除的节点有两个子节点
        if (node.left != null && node.right != null) {
            // 查找右子树中最小节点
            TreeNode minRight = node.right;
            // minRightParent 表示 minRight 的父节点
            TreeNode minRightParent = node;
            while (minRight.left != null) {
                minRightParent = minRight;
                minRight = minRight.left;
            }
            // 将 minRight 的数据替换到 node 中
            node.val = minRight.val;
            node = minRight;
            // 下面就变成了删除 minRight 了
            parent = minRightParent;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        TreeNode child;
        if (node.left != null) {
            // node 的子节点
            child = node.left;
        } else if (node.right != null) {
            child = node.right;
        } else {
            child = null;
        }

        // 删除的是根节点
        if (parent == null) {
            root = child;
        } else if (parent.left == node) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

}
