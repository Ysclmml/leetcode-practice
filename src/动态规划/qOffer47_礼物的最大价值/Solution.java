package 动态规划.qOffer47_礼物的最大价值;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}}));
        System.out.println(new Solution().maxValue(new int[][]{{1,2,5}, {3,2,1}}));
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
