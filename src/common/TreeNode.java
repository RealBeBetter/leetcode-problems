package common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wei.song
 * @since 2023/3/29 17:52
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode constructBinaryTree(final Integer[] arr) {
        // 构建和原数组相同的树节点列表
        List<TreeNode> treeNodeList = arr.length > 0 ? new ArrayList<>(arr.length) : null;
        TreeNode root = null;
        // 把输入数值数组，先转化为二叉树节点列表
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = null;
            if (arr[i] != null) {
                node = new TreeNode(arr[i]);
            }
            treeNodeList.add(node);
            if (i == 0) {
                root = node;
            }
        }
        // 遍历一遍，根据规则左右孩子赋值就可以了
        // 结束规则是 i * 2 + 1 < arr.length，避免空指针
        for (int i = 0; i * 2 + 1 < arr.length; i++) {
            TreeNode node = treeNodeList.get(i);
            if (node != null) {
                // 线性存储转连式存储关键逻辑
                node.left = treeNodeList.get(2 * i + 1);
                //  再次判断下 不忽略任何一个节点
                if (i * 2 + 2 < arr.length) {
                    node.right = treeNodeList.get(2 * i + 2);
                }
            }
        }
        return root;
    }

}
