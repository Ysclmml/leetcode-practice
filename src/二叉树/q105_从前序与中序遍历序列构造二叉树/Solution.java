package 二叉树.q105_从前序与中序遍历序列构造二叉树;

import org.junit.Test;
import 二叉树.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildNode(0, preorder.length - 1, preorder, map);
    }

    public TreeNode buildNode(int left, int right, int[] preorder, Map<Integer, Integer> map) {
        if (left > right) return null;
        int idx = map.get(preorder[index]);
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        if (left == right) return node;
        node.left = buildNode(left, idx - 1, preorder, map);
        node.right = buildNode(idx + 1, right, preorder, map);
        return node;
    }

    public TreeNode appendLeft(TreeNode node, int val) {
        node.left = new TreeNode(val);
        return node.left;
    }

    public TreeNode appendRight(TreeNode node, int val) {
        node.right = new TreeNode(val);
        return node.right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().buildTree(new int[]{3, 9, 10, 20, 15, 7}, new int[]{10, 9, 3, 15, 20, 7});
        treeNode.levelTravel();
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }
}
