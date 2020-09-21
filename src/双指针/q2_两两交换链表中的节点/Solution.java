package 双指针.q2_两两交换链表中的节点;

import 双指针.ListNode;

/**
 * Solution
 * create by yscl on 2020/9/21
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head, q = head.next;
        ListNode newHead = null, last = null;
        while (q != null) {
            if (newHead == null) newHead = q;

            if (q.next == null) {
                // 当前是偶数, 需要修复指针
                if (last != null) {
                    last.next = q;
                    q.next = p;
                    p.next = null;
                } else {
                    q.next = p;
                    p.next = null;
                }
                break;
            }
            if (last == null) {
                p.next = q.next;
                q.next = p;
            } else {
                last.next = q;
                p.next = q.next;
                q.next = p;
            }
            last = p;
            p = p.next;
            q = p.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.createListNode(new int[]{1, 2, 3, 4,5});
        node.print();
        new Solution().swapPairs(node).print();
    }
}
