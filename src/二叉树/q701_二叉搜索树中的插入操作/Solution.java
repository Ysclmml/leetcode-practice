package 二叉树.q701_二叉搜索树中的插入操作;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode p = root;
        dfs(p, val);
        return root;
    }

    private void dfs(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            } else {
                root = root.left;
            }
        }
        else if (val == root.val) {
            TreeNode node = new TreeNode(val);
            TreeNode p = root.right;
            node.right = p;
            root.right = node;
        }
        else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            } else {
                root = root.right;

            }
        }
        dfs(root, val);
    }

    public static void main(String[] args) {

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
