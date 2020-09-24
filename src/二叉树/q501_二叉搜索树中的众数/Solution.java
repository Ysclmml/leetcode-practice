package 二叉树.q501_二叉搜索树中的众数;

import org.junit.Test;
import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 二叉搜索树的中序遍历是有序的, 知道这个结论很重要
 * create by yscl on 2020/9/22
 */
public class Solution {
    int count = 0; // 最大的重复数量
    int curNum = 0; // 当前节点值
    int curCount = 0; // 当前节点值对应的数量

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        curNum = root.val;
        travel(res, root);
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    private void travel(List<Integer> res, TreeNode root) {
        if (root == null) {
            getResult(res, curCount, curNum);
            return;
        }
        travel(res, root.left);
        if (curNum == root.val) {
            curCount++;
        } else {
            // 当前节点不同, 开始计算众数
            getResult(res, curCount, curNum);
            curCount = 1;
            curNum = root.val;
        }
        travel(res, root.right);
    }

    private void getResult(List<Integer> res, int curCount, int curNum) {
        if (curCount > count) {
            res.clear();
            res.add(curNum);
            count = curCount;
        }
        else if (curCount == count) {
            if (res.size() > 0 && curNum != res.get(res.size() - 1)) res.add(curNum);
        }
    }

    public static void main(String[] args) {
        int[] ints = new Solution().findMode(TreeNode.createTree(new Integer[]{1, null, 2, 2}));
        printArray(ints);
        ints = new Solution().findMode(TreeNode.createTree(new Integer[]{1, null, 2, 2,3,null,null,3}));
        printArray(ints);
        ints = new Solution().findMode(TreeNode.createTree(new Integer[]{2147483647}));
        printArray(ints);
        ints = new Solution().findMode(TreeNode.createTree(new Integer[]{0,null,0}));
        printArray(ints);
        ints = new Solution().findMode(TreeNode.createTree(new Integer[]{-2,-2,-2}));
        printArray(ints);
        ints = new Solution().findMode(TreeNode.createTree(new Integer[]{6,2,8,0,4,7,9,null,null,2,6}));
        printArray(ints);
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

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }
}
