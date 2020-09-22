package 二叉树.q112_路径总和;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.*;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return travel(root, sum, 0);
    }

    private boolean travel(TreeNode root, int target, int cur) {
        cur += root.val;
        if (root.left == null && root.right == null) {
            return target == cur;
        }
        if (root.left != null) {
            boolean flag = travel(root.left, target, cur);
            if (flag) return true;
        }
        if (root.right != null) {
            return travel(root.right, target, cur);
        }
        return false;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertTrue(s.hasPathSum(TreeNode.createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}), 22));
        assertFalse(s.hasPathSum(TreeNode.createTree(new Integer[]{1,2}), 1));
        assertTrue(s.hasPathSum(TreeNode.createTree(new Integer[]{-2,null,-3}), -5));
    }
}
