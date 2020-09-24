package 链表.q83_删除排序链表中的重复元素;

import org.junit.Test;
import 双指针.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null, temp = head;
        while (temp != null) {
            if (pre == null || pre.val != temp.val) {
                pre = temp;
                temp = temp.next;
                continue;
            }
            // 删除当前节点
            pre.next = temp.next;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        new Solution().deleteDuplicates(ListNode.createListNode(new int[]{1,1,2})).print();
        new Solution().deleteDuplicates(ListNode.createListNode(new int[]{1,1,2,2,3})).print();
        new Solution().deleteDuplicates(ListNode.createListNode(new int[]{1,1,1,1})).print();
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
