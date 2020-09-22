package 二叉树.q617_合并二叉树;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return travel(t1, t2);
    }

    private TreeNode travel(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 != null && t2 == null) return t1;
        if (t1 == null) return t2;
        // 两者都不为null
        t1.val += t2.val;
        t1.left = travel(t1.left, t2.left);
        t1.right = travel(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.createTree(new Integer[]{1, 3, 2, 5});
        TreeNode t2 = TreeNode.createTree(new Integer[]{2,1,3,null,4,null,7});
        TreeNode t = new Solution().mergeTrees(t1, t2);
        t.levelTravel();
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }
}
