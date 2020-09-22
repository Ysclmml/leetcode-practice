package 二叉树.q100_相同的树;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.*;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return travel(p, q);
    }

    boolean travel(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        boolean flag = travel(p.left, q.left);
        if (!flag) return false;
        flag = travel(p.right, q.right);
        return flag;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        TreeNode p = TreeNode.createTree(new Integer[]{1,2,3});
        TreeNode q = TreeNode.createTree(new Integer[]{1,2,3});
        TreeNode r = TreeNode.createTree(new Integer[]{1,2,null, 3});
        TreeNode n = TreeNode.createTree(new Integer[]{1,2,4});
        assertTrue(s.isSameTree(p, q));
        assertFalse(s.isSameTree(p, r));
        assertFalse(s.isSameTree(p, n));
    }
}
