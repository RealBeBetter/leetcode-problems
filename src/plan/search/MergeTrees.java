package plan.search;

/**
 * @author Real
 * @since 2023/3/12 11:05
 */
public class MergeTrees {

    /**
     * 合并两颗二叉树
     *
     * @param root1 root1
     * @param root2 root2
     * @return {@link TreeNode}
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // 创建一个新的节点，其值为两个根节点之和
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        // 递归地合并左右子树
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        // 返回新创建的节点
        return newNode;
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
