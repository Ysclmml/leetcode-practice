package 二叉树.q109_有序链表转换二叉搜索树;

import org.junit.Test;
import 二叉树.TreeNode;
import 双指针.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // 为了遍历快速, 先将链表转换成数组
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return travel(list, 0, list.size() - 1);
    }

    private TreeNode travel(List<Integer> list, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        if (left == right) return node;
        node.left = travel(list, left, mid - 1);
        node.right = travel(list, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        TreeNode tree = new Solution().sortedListToBST(ListNode.createListNode(new int[]{-10, -3, 0, 5, 9}));
        tree.levelTravel();
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }
}
