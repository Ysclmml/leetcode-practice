package 链表.q203_移除链表元素;

import org.junit.Test;
import 双指针.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            if (p.val == val) {
                // 删除节点
                if (pre == null) {
                    head = head.next;
                    p = p.next;
                } else {
                    pre.next = p.next;
                    p = p.next;
                }
                continue;
            }
            pre = p;
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.createListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        new Solution().removeElements(node, 6);
        node.print();
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }

    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                System.out.print(nums[i]);
            } else {
                System.out.print(", " + nums[i]);
            }
        }
        System.out.println("]");
    }
}
