package 二叉树.q40_左叶子之和;

import 二叉树.TreeNode;

/**
 * Solution
 * create by yscl on 2020/9/19
 */
public class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        travel(root);
        return sum;
    }

    private void travel(TreeNode node) {
        if (node == null) return;
        if (node.left != null && node.left.left == null && node.left.right == null) sum += node.left.val;
        travel(node.left);
        travel(node.right);
    }
}
