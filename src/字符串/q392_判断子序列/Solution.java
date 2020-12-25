package 字符串.q392_判断子序列;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int j = 0, i = 0;
        for (; i < sLen; i++) {
            while (j < tLen && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            if (j == tLen) break;
            j++;
        }
        return i == sLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("axc", "ahbgsdfafaffdsadc"));
        System.out.println(new Solution().isSubsequence("agffc", "ahbgsdfafaffdsadc"));
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
