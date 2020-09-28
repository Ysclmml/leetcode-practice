package 二叉树.q129_求根到叶子节点数字之和;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int last) {
        if (root == null) return;
        int value = root.val;
        // 代表是叶节点
        if (root.left == null && root.right == null) {
            sum += last * 10 + root.val;
            return;
        }
        dfs(root.left, last * 10 + value);
        dfs(root.right, last * 10 + value);
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.sumNumbers(TreeNode.createTree(new Integer[]{1,2,3})), 25);
        assertEquals(new Solution().sumNumbers(TreeNode.createTree(new Integer[]{4,9,0,5,1})), 1026);
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
