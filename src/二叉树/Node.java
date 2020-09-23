package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Node
 * create by yscl on 2020/9/23
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node createNode(Integer[] list) {
        if (list.length == 0) return null;
        Node tree = new Node(list[0]);;
        Node curNode;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree);
        int len = list.length;
        for (int i = 1; i < len;) {
            curNode = queue.poll();
            if (list[i++] != null) {
                curNode.left = new Node(list[i - 1]);
                queue.offer(curNode.left);
            }
            if (i++ < len) {
                if (list[i - 1] != null) {
                    curNode.right = new Node(list[i - 1]);
                    queue.offer(curNode.right);
                }
            }
        }
        return tree;
    }
};
