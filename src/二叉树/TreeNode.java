package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TreeNode 二叉树的节点
 * create by yscl on 2020/9/14
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void appendLeft(TreeNode node) {
        this.left = node;
    }
    public void appendLeft(int val) {
        this.left = new TreeNode(val);
    }

    public void appendRight(TreeNode node) {
        this.right = node;
    }
    public void appendRight(int val) {
        this.right = new TreeNode(val);
    }

    /**
     * 通过数组快速生成一棵树
     * @param list 基础数的数组
     * @return 返回根结点
     */
    public static TreeNode createTree(Integer[] list) {
        if (list.length == 0) return null;
        TreeNode tree = new TreeNode(list[0]);;
        TreeNode curNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        int len = list.length;
        for (int i = 1; i < len;) {
            curNode = queue.poll();
            if (list[i++] != null) {
                curNode.left = new TreeNode(list[i - 1]);
                queue.offer(curNode.left);
            }
            if (i++ < len) {
                if (list[i - 1] != null) {
                    curNode.right = new TreeNode(list[i - 1]);
                    queue.offer(curNode.right);
                }
            }
        }
        return tree;
    }

    /**
     * 按层数遍历树
     */
    public void levelTravel() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        List<Integer> list = new ArrayList<>();
        list.add(this.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    queue.offer(node.left);
                    list.add(node.left.val);
                } else {
                    list.add(null);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    list.add(node.right.val);
                } else {
                    list.add(null);
                }
            }
        }
        System.out.println(list);
    }
}
