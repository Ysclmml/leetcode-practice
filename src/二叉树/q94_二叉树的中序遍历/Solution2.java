package 二叉树.q94_二叉树的中序遍历;

import 二叉树.TreeNode;

import java.util.*;

/**
 * 迭代方式完成
 * create by yscl on 2020/9/14
 */
// public class Solution2 {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         // 这种思路不好, 还需要保存一个是否被访问过... 废弃
//         List<Integer> list = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
//         while (!stack.isEmpty()) {
//             TreeNode node = stack.peek();
//             if (node != null) {
//                 if (node.left != null){
//                     stack.push(node.left);
//                 } else {
//                     list.add(node.val);
//                     stack.pop();
//                     if (node.right != null) {
//                         stack.push(node.right);
//                     }
//                 }
//             }
//         }
//         return list;
//     }
//
// }

/**
 * 迭代方式完成
 * create by yscl on 2020/9/14
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 这里和递归一样的思路, 遇到为空的话, 弹出栈顶元素, 然后访问root的右侧
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
