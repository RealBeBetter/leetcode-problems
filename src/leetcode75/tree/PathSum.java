package leetcode75.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 437. 路径总和 III
 * https://leetcode.cn/problems/path-sum-iii
 *
 * @author wei.song
 * @since 2023/6/3 14:46
 */
public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        List<List<Integer>> nodes = new ArrayList<>();
        return 1;
    }

    private List<Integer> getPathList(TreeNode root, List<Integer> pathNodes) {
        if (root == null) {
            return pathNodes;
        }

        return null;
    }

}
