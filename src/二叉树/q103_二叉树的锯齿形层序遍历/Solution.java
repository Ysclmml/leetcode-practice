package 二叉树.q103_二叉树的锯齿形层序遍历;

import org.junit.Test;
import 二叉树.TreeNode;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        boolean flag = true; // 标志是否需要逆序输出
        while (!queue.isEmpty()) {
            flag = !flag;
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    stack.push(node.val);
                } else {
                    tmp.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag) {
                while (!stack.isEmpty()) {
                    tmp.add(stack.pop());
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().zigzagLevelOrder(TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
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
