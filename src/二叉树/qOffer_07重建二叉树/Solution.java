package 二叉树.qOffer_07重建二叉树;

import org.junit.Test;
import 二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    Map<Integer, Integer> map;
    int curIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构建快速查找索引
        int len = inorder.length;
        if (len == 0) return null;

        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        TreeNode tree = new TreeNode(preorder[0]);
        getTreeNode(tree, preorder, 0, len - 1);
        return tree;
    }

    void getTreeNode(TreeNode root, int[] preorder, int left, int right) {
        int pos = map.get(root.val);
        if (left > right || curIdx >= preorder.length) return;
        if (left < pos) {
            curIdx++;
            root.left = new TreeNode(preorder[curIdx]);
            getTreeNode(root.left, preorder,  left, pos - 1);
        }
        if (pos < right) {
            curIdx++;
            root.right = new TreeNode(preorder[curIdx]);
            getTreeNode(root.right, preorder,pos + 1, right);
        }
    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).levelTravel();
        new Solution().buildTree(new int[]{1,2}, new int[]{1,2}).levelTravel();
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
