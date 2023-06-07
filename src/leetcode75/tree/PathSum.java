package leetcode75.tree;

import common.TreeNode;

/**
 * 437. 路径总和 III
 * https://leetcode.cn/problems/path-sum-iii
 *
 * @author wei.song
 * @since 2023/6/3 14:46
 */
public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int result = countPath(root, sum);
        int a = pathSum(root.left, sum);
        int b = pathSum(root.right, sum);
        return result + a + b;
    }

    public int countPath(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        sum = sum - root.val;
        int result = sum == 0 ? 1 : 0;
        return result + countPath(root.left, sum) + countPath(root.right, sum);
    }
}
