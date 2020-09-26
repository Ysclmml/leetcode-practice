package 回溯.q64_最小路径和;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int temp = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = temp + grid[i][0];
            temp = dp[i][0];
        }
        temp = 0;
        for (int j = 0; j < n; j++) {
            dp[0][j] = temp + grid[0][j];
            temp = dp[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        assertEquals(s.minPathSum(grid), 7);
        grid = new int[][]{{0, 1}};
        assertEquals(new Solution().minPathSum(grid), 1);
        grid = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        assertEquals(new Solution().minPathSum(grid), 1);
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
