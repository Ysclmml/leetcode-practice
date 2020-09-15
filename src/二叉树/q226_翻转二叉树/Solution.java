package 二叉树.q226_翻转二叉树;

import 二叉树.TreeNode;

/**
 * Solution
 * create by yscl on 2020/9/16
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        return getNewInvertTree(root);
    }

    private TreeNode getNewInvertTree(TreeNode root) {
        TreeNode newRoot = null;
        if (root != null) {
            newRoot = new TreeNode(root.val);
            TreeNode left = getNewInvertTree(root.left);
            TreeNode right = getNewInvertTree(root.right);
            newRoot.left = right;
            newRoot.right = left;
        }
        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        new Solution().invertTree(tree).levelTravel();
    }
}
