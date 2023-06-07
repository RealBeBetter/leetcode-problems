package leetcode75.tree;

import common.TreeNode;

/**
 * @author wei.song
 * @since 2023/6/7 15:28
 */
public class LowestCommonAncestor {

    /**
     * 最低共同祖先
     * 解法一：递归
     * p和q可能存在两种情况
     * 情况一：p和q分布在当前根的左子树和右子树上面，此时当前根就是二者最近公共祖先
     * 情况二：分布在当前根的某一边子树上，此时p和q其中之一就是当前最近公共祖先
     * <p>
     * 递归时，想象是查找p或者q，如果当前root是p或者q直接返回，如果当前root不是p或者q，那么就左右递归
     * 判空得到左右子树存在p和q的情况。
     *
     * @param root 根
     * @param p    节点1
     * @param q    节点2
     * @return {@link TreeNode}
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 属于情况一
        if (left != null && right != null) {
            return root;
        }
        // 情况二需要判断left和right哪个为空
        return left != null ? left : right;
    }

}
