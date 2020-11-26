package 字符串.q1370_上升下降字符串;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public String sortString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 取出map的键, 并排序;
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort(Character::compare);
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        StringBuilder builder = new StringBuilder();
        int sLen = s.length();
        int i = 0;
        while (i < sLen){
            builder.append(sb);
            i += sb.length();
            StringBuilder newBuilder = new StringBuilder();
            for (int j = sb.length() - 1; j >= 0; j--) {
                Character c = sb.charAt(j);
                int count = map.get(c);
                if (count > 1) {
                    map.put(c,count - 1);
                    newBuilder.append(c);
                }
            }
            sb = newBuilder;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.sortString("aaaabbbbcccc"), "abccbaabccba");
        assertEquals(s.sortString("rat"), "art");
        assertEquals(s.sortString("leetcode"), "cdelotee");
        assertEquals(s.sortString("ggggggg"), "ggggggg");
        assertEquals(s.sortString("spo"), "ops");
        assertEquals(s.sortString(""), "");
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
