package 二叉树.qOffer26_树的子结构;

import org.junit.Test;
import 二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        int heightA = getHeight(A);
        int heightB = getHeight(B);
        if (heightA < heightB || heightB == 0 || heightA == 0) return false;
        // 层级遍历A
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        int level = heightA;
        while (level >= heightB && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 比较两颗树是否相等
                boolean isEqual = compareTree(node, B);
                if (isEqual) return true;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level--;
        }
        return false;
    }

    public boolean compareTree(TreeNode node, TreeNode b) {
        // 比较两棵树, 只需要同步遍历即可.
        if ((node == null && b == null) || (node != null && b == null)) return true;
        if ((node == null && b != null) || (node.val != b.val)) {
            return false;
        }
        if (b.left != null) {
            boolean res = compareTree(node.left, b.left);
            if (!res) return res;
        }
        if (b.right != null) {
            boolean res = compareTree(node.right, b.right);
            if (!res) return res;
        }
        return true;
    }

    int getHeight(TreeNode tree) {
        int height = 0;
        while (tree != null) {
            height++;
            tree = tree.left;
        }
        return height;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareTree(TreeNode.createTree(new Integer[]{1}), TreeNode.createTree(new Integer[]{1, -4})));
        System.out.println(new Solution().isSubStructure(TreeNode.createTree(new Integer[]{1,0,1,-4,-3}), TreeNode.createTree(new Integer[]{1, -4})));
        System.out.println(new Solution().isSubStructure(TreeNode.createTree(new Integer[]{3, 4, 5, 1, 2}), TreeNode.createTree(new Integer[]{4, 1})));
        System.out.println(new Solution().isSubStructure(TreeNode.createTree(new Integer[]{1,2,3}), TreeNode.createTree(new Integer[]{3, 1})));
        System.out.println(new Solution().compareTree(TreeNode.createTree(new Integer[]{1,2,3}), TreeNode.createTree(new Integer[]{3, 1})));
        System.out.println(new Solution().compareTree(TreeNode.createTree(new Integer[]{3,1}), TreeNode.createTree(new Integer[]{3, 1})));
        System.out.println(new Solution().compareTree(TreeNode.createTree(new Integer[]{4,1}), TreeNode.createTree(new Integer[]{4, 1})));
        System.out.println(new Solution().compareTree(TreeNode.createTree(new Integer[]{3,1,null,4}), TreeNode.createTree(new Integer[]{3, 1,null,4})));
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
