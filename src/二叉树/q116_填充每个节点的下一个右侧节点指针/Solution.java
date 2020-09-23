package 二叉树.q116_填充每个节点的下一个右侧节点指针;

import org.junit.Test;
import 二叉树.Node;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node temp = root;
        while (temp.left != null) {
            Node p = temp;
            while (p != null) {
                // 安排当前节点的左节点和右节点的next指针.
                p.left.next = p.right;
                if (p.next != null) p.right.next = p.next.left;
                p = p.next;
            }
            temp = temp.left;
        }
        return root;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }
}
