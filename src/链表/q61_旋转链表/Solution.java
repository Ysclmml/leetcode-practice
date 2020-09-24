package 链表.q61_旋转链表;

import org.junit.Test;
import 双指针.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int size = 1;
        ListNode tail = head;
        // 找到尾节点, 并计数
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        if (k % size == 0) return head;
        // 尾节点连接上头指针, 形成环
        tail.next = head;
        // 计算新的头结点, 从头节点开始计数
        int n = size - k % size;
        ListNode pre = tail;
        while (n-- != 0) {
            pre = head;
            head = head.next;
        }
        // 最后停留的地方即是新的头结点, 断掉尾节点
        pre.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        new Solution().rotateRight(node, 2).print();
        node = ListNode.createListNode(new int[]{0, 1, 2 });
        new Solution().rotateRight(node, 4).print();
        node = ListNode.createListNode(new int[]{0, 1, 2 });
        new Solution().rotateRight(node, 3).print();
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
