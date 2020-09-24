package 字符串.q58_最后一个单词的长度;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!(c >= 'a' && c <= 'z' || c <= 'Z' && c >= 'A')) {
               continue;
            }
            while (i >= 0) {
                c = s.charAt(i);
                if (c >= 'a' && c <= 'z' || c <= 'Z' && c >= 'A') {
                    sum++;
                    i--;
                } else {
                    return sum;
                }

            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.lengthOfLastWord("Hello World"), 5);
        assertEquals(s.lengthOfLastWord(""), 0);
        assertEquals(s.lengthOfLastWord("Hello ss Wsorld"), 6);
    }
}
