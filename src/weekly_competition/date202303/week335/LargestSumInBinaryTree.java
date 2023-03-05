package weekly_competition.date202303.week335;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Real
 * @since 2023/3/5 10:43
 */
public class LargestSumInBinaryTree {


    /**
     * 第 k 大的层和。使用 list 存储当前层和下一层
     *
     * @param root 根节点
     * @param k    k 层
     * @return long
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        List<Long> sumList = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        LinkedList<TreeNode> nextLevelNodes = new LinkedList<>();
        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            long sum = 0;
            while (!treeNodes.isEmpty()) {
                TreeNode treeNode = treeNodes.pop();
                if (treeNode.left != null) {
                    nextLevelNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevelNodes.add(treeNode.right);
                }
                sum += treeNode.val;
            }
            treeNodes.addAll(nextLevelNodes);
            nextLevelNodes.clear();
            sumList.add(sum);
        }

        sumList.sort(Collections.reverseOrder());
        return sumList.size() < k ? -1 : sumList.get(k - 1);
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
