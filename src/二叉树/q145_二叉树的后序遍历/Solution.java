package 二叉树.q145_二叉树的后序遍历;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> tree = new LinkedList<>();
        if (root == null) return res;
        TreeNode p = null;
        while (root != null || !tree.isEmpty()) {
            while (root != null) {
                tree.push(root);
                root = root.left;
            }
            root = tree.pop();
            // 需要记录上一次的访问节点, 防止重复入栈并访问.
            if (root.right == null || root.right == p) {
                res.add(root.val);
                p = root;
                // root置空, 防止重复进入左侧子树
                root = null;
            } else {
                tree.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().postorderTraversal(TreeNode.createTree(new Integer[]{1, null, 2, 3})));
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
