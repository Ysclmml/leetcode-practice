package 二叉树.q235_二叉搜索树的最近公共祖先;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findRoot(root, p.val, q.val);
    }

    public TreeNode findRoot(TreeNode root, int p, int q) {
        if (root == null) return null;
        int maxVal = Math.max(p, q);
        int minVal = Math.min(p, q);
        if (root.val == p || root.val == q) return root;
        if (minVal < root.val && root.val < maxVal) return root;
        if (root.val < minVal) return findRoot(root.right, p, q);
        else return findRoot(root.left, p, q);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        System.out.println(new Solution().findRoot(tree, 3, 5).val);
        System.out.println(new Solution().findRoot(tree, 2,8).val);
        System.out.println(new Solution().findRoot(tree, 0,5).val);
        System.out.println(new Solution().findRoot(tree, 3, 9).val);
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }

    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                System.out.print(nums[i]);
            } else {
                System.out.print(", " + nums[i]);
            }
        }
        System.out.println("]");
    }
}
