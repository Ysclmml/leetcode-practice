package 数组.q81_搜索旋转排序数组;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return false;
        int left = 0;
        while (++left < len && nums[left] >= nums[left - 1]){}
        if (left == len) left = 0;
        int right = len - 1 + left;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = nums[mid % len];
            if (val == target) return true;
            if (val < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertTrue(s.search(new int[]{2,5,6,0,0,1,2}, 1));
        assertTrue(s.search(new int[]{2,5,6,0,0,1,2}, 6));
        assertFalse(s.search(new int[]{2,5,6,0,0,1,2}, -1));
        assertFalse(s.search(new int[]{2,5,6,0,0,1,2}, 7));
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
