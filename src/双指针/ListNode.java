package 双指针;

import java.util.List;

/**
 * ListNode
 * create by yscl on 2020/9/21
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    
    public static ListNode createListNode(int[] values) {
        ListNode node = null;
        ListNode p = null;
        for (int x : values) {
            if (node == null ) {
                node = new ListNode(x);
                p = node;
            } else {
                p.next = new ListNode(x);
                p = p.next;
            }
        }
        return node;
    }

    public void print() {
        ListNode p = this;
        while (p != null) {
            if (p.next != null)
                System.out.print(p.val + "->");
            else
                System.out.print(p.val + "\n");
            p = p.next;
        }
    }
}
