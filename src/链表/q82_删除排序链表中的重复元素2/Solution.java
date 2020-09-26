package 链表.q82_删除排序链表中的重复元素2;

import org.junit.Test;
import 双指针.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, newHead = null;
        ListNode cur = head;
        // 扫描到第一个不重复的值开始
        while (true) {
            if (pre == null) {
                if (cur.next != null) {
                    if (cur.next.val != cur.val) {
                        newHead = cur;
                        pre = newHead;
                        cur = cur.next;
                    } else {
                        int val = cur.val;
                        cur = cur.next.next;
                        while(cur != null && cur.val == val) {
                            cur = cur.next;
                        }
                        if (cur == null) {
                            return null;
                        }
                        // 重新进入循环进行一轮判断
                    }
                } else {
                    // 表示当前只有一个元素, 直接返回
                    newHead = cur;
                    return newHead;
                }
            } else {
                // 进入这个分支表示pre绝对不会与cur的值相等
                if (cur.next != null) {
                    if (cur.val != cur.next.val) {
                        // 需要赋值
                        pre.next = cur;
                        pre = cur;
                        cur = cur.next;
                    } else {
                        int val = cur.val;
                        cur = cur.next.next;
                        while (cur != null && cur.val == val){
                            cur = cur.next;
                        }
                        if (cur == null) {
                            // 直接结束, 到了末尾
                            pre.next = null;
                            return newHead;
                        }
                    }
                } else {
                    // 代表已经到末尾了, 可以直接返回了
                    pre.next = cur;
                    return newHead;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = s.deleteDuplicates(ListNode.createListNode(new int[]{1, 2, 3, 3, 4, 4, 5}));
        if (node != null) node.print();
        node = s.deleteDuplicates(ListNode.createListNode(new int[]{1, 1,1,1,2,3}));
        if (node != null) node.print();
        node = s.deleteDuplicates(ListNode.createListNode(new int[]{1, 1,1,1,2,3,3}));
        if (node != null) node.print();
        node = s.deleteDuplicates(ListNode.createListNode(new int[]{1, 1,1,1,2,2,3,3}));
        if (node != null) node.print();
        else System.out.println("null");
        node = s.deleteDuplicates(ListNode.createListNode(new int[]{0,1,2,2,3,4}));
        if (node != null) node.print();
        else System.out.println("null");
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
