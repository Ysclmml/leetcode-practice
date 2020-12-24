package 字符串.q345_反转字符串中的元音字母;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    static boolean[] vowel;

    static {
        vowel = new boolean[26];
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            vowel[c - 'a'] = true;
        }
    }

    public boolean isVowel(char c) {
        if ('a' <= c && c <= 'z') {
            return vowel[c - 'a'];
        } else if ('A' <= c && c <= 'Z') {
            return vowel[c - 'a' + 32];
        }
        return false;
    }

    public String reverseVowels(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = len - 1;

        while (i < j) {
            while (i < j && !isVowel(sb.charAt(i))) {
                i++;
            }
            while (i < j && !isVowel(sb.charAt(j))) {
                j--;
            }
            if (i < j) {
                // 交换两个原音字母
                char c = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, c);
                i++;
                j--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
        System.out.println(new Solution().reverseVowels("leetcode"));
        System.out.println(new Solution().reverseVowels("leetocode"));
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
