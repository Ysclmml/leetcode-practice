package 回溯.q131_分割回文串;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution2 {
    public List<List<String>> partition(String s) {
        char[] str = s.toCharArray();

        // 判断是否是回文串 [1, 2, 3, 5, 5, 3, 7], 优化, 实现用一个dp数组, 存储所有状态.
        int len = str.length;
        boolean[][] dp = new boolean[len][len];
        // dp[i][j] = dp[i] == dp[j] && dp[i+1][j-1]
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) dp[i][j] = true;
                else if (j - i == 1) dp[i][j] = str[i] == str[j];
                else dp[i][j] = str[i] == str[j] && dp[i+1][j-1];
            }
        }
        return findPartition(dp, str, 0, s.length() - 1);
    }

    private List<List<String>> findPartition(boolean[][] dp, char[] str, int left, int right) {
        List<List<String>> res = new ArrayList<>();
        if (left > right) {
            res.add(new ArrayList<>());
            return res;
        }
        for (int i = left; i <= right; i++) {
            // 先判断自己当前分法本身是否是回文串, 否则就往下一种分法.
            if (!dp[left][i]) {
                continue;
            }
            List<List<String>> rightPar = findPartition(dp, str, i + 1, right);
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

    public static void main(String[] args) {
        System.out.println(new Solution2().partition("aab"));
        System.out.println(new Solution2().partition("aaa"));
    }

    @Test
    public void testSolution() {
        Solution2 s = new Solution2();
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
