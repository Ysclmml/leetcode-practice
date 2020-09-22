package 二叉树.q106_从中序与后序遍历序列构造二叉树;

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

    int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        index = inorder.length - 1;
        return buildNode(0, postorder.length - 1, postorder, map);
    }

    public TreeNode buildNode(int left, int right, int[] postorder, Map<Integer, Integer> map) {
        if (left > right) return null;
        int idx = map.get(postorder[index]);
        TreeNode node = new TreeNode(postorder[index]);
        index--;
        if (left == right) return node;
        // 注意这里, 因为是后续遍历, 反过来就需要遍历右侧的节点, 然后才是左节点
        node.right = buildNode(idx + 1, right, postorder, map);
        node.left = buildNode(left, idx - 1, postorder, map);
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
        TreeNode treeNode = new Solution().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        treeNode.levelTravel();
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }
}
