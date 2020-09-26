package 回溯.q95_不同的二叉搜索树2;

import org.junit.Test;
import 二叉树.TreeNode;
import 双指针.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 思路错误, 陷入误区, 直接参考官方题解
 * create by yscl on 2020/9/22
 */
public class Solution {
    List<TreeNode> res = new ArrayList<>();

    // public List<TreeNode> generateTrees(int n) {
    //     boolean[] visited = new boolean[n];
    //
    //     for (int i = 1; i <= n; i++) {
    //         // 从1开始构造节点
    //
    //     }
    // }

    /**
     * left是当前序列的左侧, right是连续序列的有边界, cur表示当前节点的值
     */
    private void dfs(TreeNode head, TreeNode tree, int left, int cur, int right, int n, int curSize) {
        if (n == curSize) {
            // 这里需要copy一棵树i
            // 这里需要重新赋值每一个结点, 思路错误.... 放弃这种解法
            TreeNode newHead = new TreeNode(head.val);
            newHead.left = head.left;
            newHead.right = head.right;
            res.add(newHead);
            return;
        }
        for (int i = left; i < cur; i++) {
            tree.left = new TreeNode(i);
            dfs(head, tree.left, left, i, cur - 1, n, curSize + 1);
        }
        for (int j = right; j > cur; j--) {
            tree.right = new TreeNode(j);
            dfs(head, tree.right, cur + 1, j, right, n, curSize + 1);
        }
    }

    public static void main(String[] args) {

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
