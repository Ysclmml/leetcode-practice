package 二叉树.q110_平衡二叉树;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.*;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        maxHeight(root);
        return flag;
    }

    private int maxHeight(TreeNode root) {
        if (!flag) return 0;
        if (root == null) return 0;
        int leftHeight = maxHeight(root.left) + 1;
        int rightHeight = maxHeight(root.right) + 1;
        if (Math.abs(leftHeight - rightHeight) >= 2) flag = false;
        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertTrue(s.isBalanced(TreeNode.createTree(new Integer[]{3,9,20,null,null,15,7})));
    }
}
