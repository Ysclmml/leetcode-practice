package 字符串.q58_I翻转单词顺序;

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

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        List<String> s2 = new ArrayList<>();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("") || s1[i].equals(" ")) {
                continue;
            }
            s2.add(s1[i]);
        }
        return String.join(" ", s2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("  the  aaa !!! jjj"));
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
