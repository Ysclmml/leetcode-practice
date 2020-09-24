package 字符串.q67_二进制求和;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        int carry = 0;
        for (int i = len1 - 1, j = len2 - 1;; i--, j--) {
            if (i < 0 && j < 0) break;
            int x, y;
            if (i < 0) x = 0;
            else x = a.charAt(i) - '0';
            if (j < 0) y = 0;
            else y = b.charAt(j) - '0';
            sb.append(x ^ y ^ carry);
            carry = ((x | y) & carry | (x | carry) & y | (y | carry) & x);
        }
        if (carry != 0) sb.append(1);
        return new String(sb.reverse());
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.addBinary("1", "11"), "100");
        assertEquals(s.addBinary("1", "10"), "11");
    }
}
