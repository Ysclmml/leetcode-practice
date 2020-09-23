package 二叉树.q117_填充每个节点的下一个右侧节点指针2;

import org.junit.Test;
import 二叉树.Node;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板, 这个奇怪的判断太多了, 重新参考官方解法, 书写
 * create by yscl on 2020/9/22
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node temp = root;
        while (temp != null) {

            Node p = temp;
            while (p != null) {
                // 安排当前节点的左节点和右节点的next指针.

                if (p.left != null) {
                    if (p.right != null)
                        p.left.next = p.right;
                    else {
                        Node q = p.next;
                        while (q != null) {
                            if (q.left != null) {
                                p.left.next = q.left;
                                break;
                            } else if (q.right != null) {
                                p.left.next = q.right;
                                break;
                            }
                            q = q.next;
                        }
                        p = q;
                        continue;
                    }
                }
                if (p.right != null) {
                    Node q = p.next;
                    while (q != null) {
                        if (q.left != null) {
                            p.right.next = q.left;
                            break;
                        } else if (q.right != null) {
                            p.right.next = q.right;
                            break;
                        }
                        q = q.next;
                    }
                    p = q;
                    continue;
                }
                p = p.next;
            }
            if (temp.left != null) {
                temp = temp.left;
            } else if (temp.right != null) {
                temp = temp.right;
            } else {
                Node t = temp.next;
                while (t != null && t.left == null && t.right == null) {
                    t = t.next;
                }
                if (t == null) {
                    temp = null;
                    break;
                }
                temp = t.left != null ? t.left : t.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        new Solution().connect(Node.createNode(new Integer[]{3,9,20,null,null,15,7}));
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }
}
