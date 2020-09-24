package 字符串.q93_复原IP地址;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] str = s.toCharArray();
        int length = s.length();
        if (length < 4 || length > 12) return res;
        for (int i = 0; i < 3; i++) {
            // 要判断剩下的长度 3 <= len <= 9, 不然后面的肯定不合法
            if (length - 1 - i < 3 || length - 1 - i > 9) continue;
            if (!check(0, i, str)) continue;
            String first = s.substring(0, i + 1);
            for (int j = i + 1; j < i + 4 && j < length; j++) {
                // 要判断剩下的长度 2 <= len <= 6, 不然后面的肯定不合法
                if (length - 1 - j > 6 || length - 1 - j < 2) continue;
                if (!check(i + 1, j, str)) continue;
                String second = s.substring(i + 1, j + 1);
                for (int k = j + 1; k < j + 4 && k < length; k++) {
                    // 要判断剩下的长度 1 <= len <=3 不然后面的肯定不合法
                    if (length - 1 - k > 3 || length - 1 - k < 1) continue;
                    if (!check(j + 1, k, str)) continue;
                    String third = s.substring(j + 1, k + 1);
                    if (check(k + 1, length - 1, str)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(first)
                        .append(".")
                        .append(second)
                        .append(".")
                        .append(third)
                        .append(".")
                        .append(s, k + 1, length);
                        res.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }

    private boolean check(int start, int end, char[] str) {
        // start 表示字符数组的起始坐标
        // end 表示终止坐标
        int len = end - start;
        if (len > 0) if (str[start] == '0') return false;
        if (len > 2) return false;
        if (len == 2) {
            if (str[start] >= '3') return false;
            return str[start] != '2' || (str[start + 1] <= '5' && (str[start + 1] != '5' || str[end] <= '5'));
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
        System.out.println(new Solution().restoreIpAddresses("0000"));
        System.out.println(new Solution().restoreIpAddresses("1111"));
        System.out.println(new Solution().restoreIpAddresses("010010"));
        System.out.println(new Solution().restoreIpAddresses("101023"));
        System.out.println(new Solution().restoreIpAddresses("2552551113525525511135"));
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
