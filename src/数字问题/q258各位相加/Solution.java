package 数字问题.q258各位相加;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int addDigits(int num) {
        if (num == 0) return 0;
        String s = Integer.toString(num);
        int total = 0;
        for (char c : s.toCharArray()) {
            total += c - '0';
        }
        if (total % 9 == 0) return 9;
        return total % 9;
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
