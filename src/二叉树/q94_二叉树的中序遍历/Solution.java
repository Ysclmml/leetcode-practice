package 二叉树.q94_二叉树的中序遍历;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 * create by yscl on 2020/9/14
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        _travel(root, list);
        return list;
    }

    private void _travel(TreeNode node, List<Integer> list) {
        if (node != null) {
            _travel(node.left, list);
            list.add(node.val);
            _travel(node.right, list);
        }
    }
}
