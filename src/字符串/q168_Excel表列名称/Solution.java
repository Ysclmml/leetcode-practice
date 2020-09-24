package 字符串.q168_Excel表列名称;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n -= 26;
            } else {
                sb.append((char)(n % 26 + 'A' - 1));
            }
            n /= 26;
        }
        return new String(sb.reverse());
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.convertToTitle(28), "AB");
        assertEquals(s.convertToTitle(52), "AZ");
        assertEquals(s.convertToTitle(1), "A");
        assertEquals(s.convertToTitle(1234801), "BRFPI");
        assertEquals(s.convertToTitle(701), "ZY");
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
