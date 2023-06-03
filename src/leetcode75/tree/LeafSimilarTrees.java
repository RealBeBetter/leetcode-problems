package leetcode75.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 *
 * @author wei.song
 * @since 2023/6/3 11:17
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeNode.constructBinaryTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
        TreeNode treeNode2 = TreeNode.constructBinaryTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
        LeafSimilarTrees test = new LeafSimilarTrees();
        System.out.println(test.leafSimilar(treeNode1, treeNode2));
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        leaves1 = getLeaves(leaves1, root1);
        List<Integer> leaves2 = new ArrayList<>();
        leaves2 = getLeaves(leaves2, root2);

        if (leaves1.size() != leaves2.size()) {
            return false;
        }

        for (int i = 0; i < leaves1.size(); i++) {
            if (leaves1.get(i).equals(leaves2.get(i))) {
                continue;
            }
            return false;
        }

        return true;
    }

    public List<Integer> getLeaves(List<Integer> leaves, TreeNode root) {
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return leaves;
        }

        if (root.left != null) {
            getLeaves(leaves, root.left);
        }

        if (root.right != null) {
            getLeaves(leaves, root.right);
        }

        return leaves;
    }

}
