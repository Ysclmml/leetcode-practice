package 回溯.q96_不同的二叉搜索树;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 使用动态规划思路, 找规律
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int total = 0;
            for (int j = 0; j < i; j++) {
                total += dp[j] * dp[i - j - 1];
            }
            dp[i] = total;
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.numTrees(4), 14);
        assertEquals(s.numTrees(5), 42);
        assertEquals(s.numTrees(6), 132);
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
