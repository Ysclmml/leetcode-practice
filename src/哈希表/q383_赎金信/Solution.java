package 哈希表.q383_赎金信;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dst = new int[26];
        int[] src = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            src[c - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            dst[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (dst[i] < src[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("a", "aab"));
        System.out.println(new Solution().canConstruct("aa", "ab"));
        System.out.println(new Solution().canConstruct("aa", "aab"));
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
