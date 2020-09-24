package 回溯.q63_不同路径2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 动态规划法 dp[m][n] = dp[m-1][n] + dp[m][n-1]
 * create by yscl on 2020/9/25
 */
public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        if (obstacleGrid[0][0] == 1|| obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                // 一旦一个位置不可达, 后面的都不可到达
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 1) {
                dp[0][j] = 1;
            } else {
                // 一旦一个位置不可达, 后面的都不可到达
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution2 s = new Solution2();
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertEquals(s.uniquePathsWithObstacles(grid), 2);
        grid = new int[][]{{0, 1}};
        assertEquals(new Solution2().uniquePathsWithObstacles(grid), 0);
        grid = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        assertEquals(new Solution2().uniquePathsWithObstacles(grid), 0);
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
