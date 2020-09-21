package 二叉树.q538_把二叉搜索树转换为累加树;

import 二叉树.TreeNode;

/**
 * Solution
 * create by yscl on 2020/9/21
 */
public class Solution {
    int last = 0;
    public TreeNode convertBST(TreeNode root) {
        travel(root);
        return root;
    }

    private void travel(TreeNode root) {
        if (root == null) return;
        travel(root.right);
        last += root.val;
        root.val = last;
        travel(root.left);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{5, 2, 13});
        new Solution().convertBST(tree);
        tree.levelTravel();
    }
}
