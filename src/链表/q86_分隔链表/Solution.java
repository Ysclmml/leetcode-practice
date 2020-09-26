package 链表.q86_分隔链表;

import org.junit.Test;
import 双指针.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = null, large = null;
        ListNode p = head, newHead = null, largeHead = null;
        while(p != null) {
            if (p.val < x) {
                if (small == null) {
                    small = p;
                    newHead = small;
                }
                else {
                    small.next = p;
                    small = p;
                }
            } else {
                if (large == null) {
                    large = p;
                    largeHead = p;
                } else {
                    large.next = p;
                    large = p;
                }
            }
            p = p.next;
        }
        if (small != null) small.next = largeHead;
        else newHead = largeHead;
        // 给large一个结束点
        if (large != null) large.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        new Solution().partition(ListNode.createListNode(new int[]{1,4,3,2,5,2,3,1}), 3).print();
        new Solution().partition(ListNode.createListNode(new int[]{1,4,3,2,5,2,3,6}), 0).print();
        new Solution().partition(ListNode.createListNode(new int[]{1,4,3,2,5,2,3,6}), 4).print();
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
