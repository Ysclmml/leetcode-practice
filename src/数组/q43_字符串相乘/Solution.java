package 数组.q43_字符串相乘;

import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.*;

/**
 * Solution
 * create by yscl on 2020/9/22
 */
public class Solution {
    public String multiply(String num1, String num2) {
        // 321 * 199
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int totalLen = n1.length + n2.length;
        char[] res = new char[totalLen];
        int[] carry = new int[totalLen];
        Arrays.fill(res, '0');
        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                int tmp = (n1[n1.length - i - 1] - '0') * (n2[n2.length - j - 1] - '0');
                if (tmp < 10) {
                    res[i + j] += tmp;
                    if (res[i + j] > '9') {
                        res[i + j] -= 10;
                        carry[i + j + 1]++;
                    }
                } else {
                    int ones = tmp % 10, tens = tmp / 10;
                    res[i + j] += ones;
                    if (res[i + j] > '9') {
                        res[i + j] -= 10;
                        carry[i + j + 1]++;
                    }
                    res[i + j + 1] += tens;
                    if (res[i + j + 1] > '9') {
                        res[i + j + 1] -= 10;
                        carry[i + j + 2]++;
                    }
                }
            }
        }
        // 最后统一加上进位
        // 最后倒序输出, 如果最后一位是0, 取消
        StringBuilder sb = new StringBuilder();
        int newCarry = 0;
        for (int i = 0; i < totalLen; i++) {
            int tmp = res[i] - '0' + carry[i] + newCarry;
            res[i] = (char)(tmp % 10 + '0');
            sb.append(res[i]);
            newCarry = tmp / 10;
        }
        if (sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);
        return new String(sb.reverse());
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.multiply("123", "9"), "1107");
        assertEquals(s.multiply("123", "1"), "123");
        assertEquals(s.multiply("123", "123456789"), "15185185047");
        assertEquals(s.multiply("123456789", "0"), "0");
    }
}
