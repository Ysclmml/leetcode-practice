package 数组.qOffer53_第一个只出现一次的字符;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    // public char firstUniqChar(String s) {
    //     Map<Character, Integer> map = new LinkedHashMap<>();
    //     for (Character c : s.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0));
    //     }
    // }

    public char firstUniqChar(String s) {
        int[] counts = new int[26];
        int[] order = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
            order[c - 'a'] = i;
        }
        int minIndex = 100000;
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 1) {
                minIndex = Math.min(minIndex, order[i]);
            }
        }
        return minIndex == 100000 ? ' ' : s.charAt(minIndex);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("abaccdeff"));
        System.out.println(new Solution().firstUniqChar("abbaccdeff"));
        System.out.println(new Solution().firstUniqChar("abbbzaccdeff"));
        System.out.println(new Solution().firstUniqChar("abbbzzzzaccddeeff"));
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
