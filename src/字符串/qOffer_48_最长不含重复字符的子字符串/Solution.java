package 字符串.qOffer_48_最长不含重复字符的子字符串;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 用pos Map来标记字符的所有顺序
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 如果对应的键不存在或已经存在了但是对应的索引超出了当前的范围
            if (!map.containsKey(c) || map.get(c) < start) {
                map.put(c, i);
                maxLen = Math.max(maxLen, end - start + 1);
                end++;
            } else {
                // 重置索引信息.
                start = map.get(c) + 1;
                map.put(c, i);
                end = i + 1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("aab"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring(""));
        System.out.println(new Solution().lengthOfLongestSubstring("aaaabbbbbcccddedf"));
        System.out.println(new Solution().lengthOfLongestSubstring("abc BabcbbAAA ABBB"));
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
