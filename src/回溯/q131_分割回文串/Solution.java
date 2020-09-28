package 回溯.q131_分割回文串;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public List<List<String>> partition(String s) {
        char[] str = s.toCharArray();
        return findPartition(str, 0, s.length() - 1);
    }

    private List<List<String>> findPartition(char[] str, int left, int right) {
        List<List<String>> res = new ArrayList<>();
        if (left > right) {
            res.add(new ArrayList<>());
            return res;
        }
        for (int i = left; i <= right; i++) {
            // 先判断自己当前分法本身是否是回文串, 否则就往下一种分法.
            if (!isPalindrome(str, left, i)) {
                continue;
            }
            List<List<String>> rightPar = findPartition(str, i + 1, right);
            for (List<String> rightList : rightPar) {
                List<String> tmp = new ArrayList<>();
                String tmpStr = new String(str, left, i - left + 1);
                tmp.add(tmpStr);
                tmp.addAll(rightList);
                res.add(tmp);
            }
        }
        return res;
    }

    // 判断是否是回文串 [1, 2, 3, 5, 5, 3, 7]
    private boolean isPalindrome(char[] str, int left, int right) {
        if (left == right) return true;
        // 正常判断
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (str[i + left] != str[right - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
        System.out.println(new Solution().partition("aaa"));
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
