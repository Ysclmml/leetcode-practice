package 字符串.q409_最长回文串;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int longestPalindrome(String s) {
        int[] charNum = new int[52];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= 'a') {
                charNum[c - 'a']++;
            } else {
                charNum[c - 'A' + 26]++;
            }
        }
        int resLen = 0;
        int leftNum = 0;
        for (int i = 0; i < 52; i++) {
            resLen += charNum[i] / 2 * 2;
            if (leftNum == 0) {
                leftNum = charNum[i] % 2;
            }
        }
        return resLen + leftNum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abccccdd"));
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
