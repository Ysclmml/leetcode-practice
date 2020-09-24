package 数组.q219_存在重复元素2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < i + k + 1 && j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertTrue(s.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        assertTrue(s.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        assertFalse(s.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
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
