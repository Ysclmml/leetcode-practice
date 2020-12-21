package 数字问题.q231_2的幂;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        int tmp = 1;
        for (int i = 0; i < 31; i++) {
            if (tmp == n) return true;
            tmp <<= 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo((int) Math.pow(2, 30)));
        System.out.println(new Solution().isPowerOfTwo((int) Math.pow(2, 4)));
        System.out.println(new Solution().isPowerOfTwo((int) Math.pow(2, 31) - 1));
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
