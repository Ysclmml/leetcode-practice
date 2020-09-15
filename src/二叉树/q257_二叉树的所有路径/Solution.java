package 二叉树.q257_二叉树的所有路径;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution
 * create by yscl on 2020/9/15
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        // LinkedList<Integer> path = new LinkedList<>();
        findLeafPath(root, new StringBuilder(), res);
        return res;
    }

    // 对java一直不是特别熟, 才会犯下面这种问题, 存储路径直接用stringBuilder就可以了
    // private void findLeafPath(TreeNode root, LinkedList<Integer> path, List<String> res) {
    //     if (root == null) return;
    //     path.add(root.val);
    //     findLeafPath(root.left, path, res);
    //     findLeafPath(root.right, path, res);
    //     // 判断当前节点是否有左右节点, 如果没有, 则表示是叶节点
    //     if (root.left == null && root.right == null) {
    //         res.add(getPath(path));
    //     }
    //     path.removeLast(); // 移除当前路径上的最后一个元素
    // }
    //
    // private String getPath(LinkedList<Integer> path) {
    //     StringBuilder sb = new StringBuilder();
    //     boolean start = false;
    //     for (Integer val : path) {
    //         if (!start)  {
    //             sb.append(val.toString());
    //             start = true;
    //         } else {
    //             sb.append("->").append(val.toString());
    //         }
    //     }
    //     return sb.toString();
    // }

    private void findLeafPath(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) return;
        int curLen = sb.length();
        if (curLen == 0) sb.append(root.val);
        else sb.append("->").append(root.val);
        findLeafPath(root.left, sb, res);
        findLeafPath(root.right, sb, res);
        // 判断当前节点是否有左右节点, 如果没有, 则表示是叶节点
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        sb.delete(curLen, sb.length()); // 移除当前路径上的最后一个元素
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1, 2, 3, null, 5});
        List<String> list = new Solution().binaryTreePaths(tree);
        for (String s :list) {
            System.out.println(s);
        }
    }
}
