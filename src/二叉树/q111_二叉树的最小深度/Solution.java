package 二叉树.q111_二叉树的最小深度;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    int min = Integer.MAX_VALUE; // 最小路径短路, 当某次递归达到当前最小深度时, 取消递归

    public int minDepth(TreeNode root) {
        return root == null ? 0 : minHeight(root, 1);
    }

    private int minHeight(TreeNode root, int curHeight) {
        if (root.left == null && root.right == null){
            if (min > curHeight) min = curHeight;
            return curHeight;
        }
        // 如果已经出了最小值, 那么当前高度大于最小值时, 直接短路, 返回结果, 结束递归
        if (curHeight >= min) return min;
        int leftHeight = Integer.MAX_VALUE, rightHeight = Integer.MAX_VALUE;
        if (root.left != null)
            leftHeight = minHeight(root.left, curHeight + 1);
        if (root.right != null)
            rightHeight = minHeight(root.right, curHeight + 1);
        return Math.min(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.minDepth(TreeNode.createTree(new Integer[]{3,9,20,null,null,15,7})), 2);
        assertEquals(s.minDepth(TreeNode.createTree(new Integer[]{1,2})), 2);
    }
}
