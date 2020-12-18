package 双指针.q链表中倒数第k个节点;

import org.junit.Test;
import 双指针.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, quick = head;
        while (k-- > 0 && quick != null) {
            quick = quick.next;
        }
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        new Solution().getKthFromEnd(ListNode.createListNode(new int[]{1, 2, 3, 4, 5}), 4).print();
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
