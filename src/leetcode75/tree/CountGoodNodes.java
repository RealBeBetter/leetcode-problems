package leetcode75.tree;

import common.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 * https://leetcode.cn/problems/count-good-nodes-in-binary-tree
 *
 * @author wei.song
 * @since 2023/6/3 11:49
 */
public class CountGoodNodes {

    public static void main(String[] args) {
        // 从根节点到当前节点中最大的节点。
        TreeNode treeNode = TreeNode.constructBinaryTree(new Integer[]{3, 1, 4, 3, null, 1, 5});
        CountGoodNodes test = new CountGoodNodes();
        System.out.println(test.goodNodes(treeNode));
    }

    public int goodNodes(TreeNode root) {
        return depthFirstSearch(root, root.val);
    }

    private int depthFirstSearch(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val >= max) {
            res++;
            max = root.val;
        }

        return depthFirstSearch(root.left, max) + depthFirstSearch(root.right, max) + res;
    }

}
