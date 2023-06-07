package leetcode75.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view
 *
 * @author wei.song
 * @since 2023/6/7 20:33
 */
public class RightSideView {

    public static void main(String[] args) {
        RightSideView test = new RightSideView();
        TreeNode root = TreeNode.constructBinaryTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        System.out.println(test.rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> rightView = new ArrayList<>();
        LinkedList<TreeNode> currentLayout = new LinkedList<>();
        LinkedList<TreeNode> nextLayout = new LinkedList<>();
        currentLayout.add(root);
        while (!currentLayout.isEmpty()) {
            TreeNode last = currentLayout.getLast();
            rightView.add(last.val);
            while (!currentLayout.isEmpty()) {
                TreeNode treeNode = currentLayout.removeFirst();
                if (treeNode.left != null) {
                    nextLayout.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLayout.add(treeNode.right);
                }
            }
            if (!nextLayout.isEmpty()) {
                currentLayout.addAll(nextLayout);
                nextLayout.clear();
            }
        }

        return rightView;
    }


    public List<Integer> rightSideViewSingleLayout(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> rightView = new ArrayList<>();
        LinkedList<TreeNode> layout = new LinkedList<>();
        layout.add(root);
        while (!layout.isEmpty()) {
            TreeNode last = layout.getLast();
            rightView.add(last.val);
            int size = layout.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = layout.removeFirst();
                if (treeNode.left != null) {
                    layout.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    layout.add(treeNode.right);
                }
            }
        }

        return rightView;
    }

}
