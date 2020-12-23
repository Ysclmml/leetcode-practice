package 字符串.q387_字符串中的第一个唯一字符;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            count[idx]++;
            if (count[idx] == 1)
                pos[idx] = i;
        }
        int minIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                if (minIdx == -1) minIdx = pos[i];
                else minIdx = Math.min(minIdx, pos[i]);
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
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
