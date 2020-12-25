package 数字问题.q367_有效的完全平方数;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = Math.min(num, 92680);
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 下面可能会溢出, 所以错误.
            int fac = mid * mid;
            if (fac == num) return true;
            if (fac < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left * left == num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(16));
        System.out.println(new Solution().isPerfectSquare(14));
        System.out.println(new Solution().isPerfectSquare(1));
        System.out.println(new Solution().isPerfectSquare(0));
        System.out.println(new Solution().isPerfectSquare(100));
        System.out.println(new Solution().isPerfectSquare(101));
        System.out.println(new Solution().isPerfectSquare(2147483647));
        System.out.println(new Solution().isPerfectSquare(808201));
        System.out.println(new Solution().isPerfectSquare(2147395600));
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
