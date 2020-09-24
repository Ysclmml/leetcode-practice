package 字符串.q205_同构字符串;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int len = s.length();
        // 还需要注意一个字母只能映射一次
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!map.containsKey(c1)) {
                if (set.contains(c2)) return false;
                map.put(c1, c2);
                set.add(c2);
            } else {
                if (c2 != map.get(c1)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertTrue(s.isIsomorphic("egg", "add"));
        assertFalse(s.isIsomorphic("foo", "bar"));
        assertTrue(s.isIsomorphic("paper", "title"));
        assertTrue(s.isIsomorphic("papa", "papa"));
        assertTrue(s.isIsomorphic("paperp", "titlet"));
        assertFalse(s.isIsomorphic("paperp", "titlea"));
        assertFalse(s.isIsomorphic("ab", "aa"));
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
