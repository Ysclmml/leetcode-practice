package 二叉树.q117_填充每个节点的下一个右侧节点指针2;

import org.junit.Test;
import 二叉树.Node;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板, 这个奇怪的判断太多了, 重新参考官方解法, 书写
 * create by yscl on 2020/9/22
 */
public class Solution2 {
    public Node connect(Node root) {
        // 遍历上一层的时候, 提前把下一层串起来, 本质就是使用一个单链表
        Node head = root;
        while (head != null) {
            Node level = new Node();
            Node tail = level;
            // level的next代表下一层的开始
            while (head != null) {
                // 在这里构造一个链表, 下次就是在遍历这个链表
                if (head.left != null) {
                    tail.next = head.left;
                    tail = tail.next;
                }
                if (head.right != null) {
                    tail.next = head.right;
                    tail = tail.next;
                }
                head = head.next;
            }
            head = level.next;
        }
        return root;
    }

    public static void main(String[] args) {
        new Solution2().connect(Node.createNode(new Integer[]{3,9,20,null,null,15,7}));
    }

    @Test
    public void testSolution() {
        Solution2 s = new Solution2();
        assertEquals("", "");
    }
}
