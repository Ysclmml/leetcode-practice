package 二叉树.q222_完全二叉树的节点个数;

import org.junit.Test;
import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */

public class Solution {

    int nullCount = 0;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;
        TreeNode p = root;
        int level = 0;
        while (p.left != null) {
            level++;
            p = p.left;
        }

        // 按照右左中的顺序进行遍历, 遇到不为的话就返回
        travel(root, level, 0);
        return (int) Math.pow(2, level + 1) - 1 - nullCount;
    }

    public void travel(TreeNode root, int level, int curLevel){
        if (root.right != null) {
            if (curLevel == level - 1) return;
            travel(root.right, level, curLevel + 1);
        } else {
          nullCount++;
        }
        if (root.left != null) {
            if (curLevel == level - 1) return;
            travel(root.left, level, curLevel + 1);
        } else {
            nullCount++;
        }
    }

    public static void main(String[] args) {
        // TreeNode tree = TreeNode.createTree(new Integer[]{1, 2, 3, 4, 5, 6});
        TreeNode tree = TreeNode.createTree(new Integer[]{1, 2,3,4,5,6,7,8,9,10,11,12,15,18,19});
        System.out.println(new Solution().countNodes(tree));
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
