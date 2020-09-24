package 回溯.q63_不同路径2;

import org.junit.Test;

import java.util.Observable;

import static org.junit.Assert.assertEquals;

/**
 * 超时.. 暴力破解法
 * create by yscl on 2020/9/22
 */
public class Solution {
    int count = 0; // 一共解的个数
    int m;  // 棋盘的行数
    int n;  // 棋盘的列数
    int[][] dir = new int[][]{{0, 1}, {1, 0}}; // 目标在右下角, 所以只设置2个方向
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        if (m == 0) return 0;
        n = obstacleGrid[0].length;
        dfs(obstacleGrid, 0, 0);
        return count;
    }

    private void dfs(int[][] obstacleGrid, int row, int col) {
        if (row >= m || col >= n) {
            return;
        }
        if (obstacleGrid[row][col] == 1) return;
        if (row == m - 1 && col == n - 1) {
            count++;
            return;
        }
        for (int[] d : dir) {
            dfs(obstacleGrid, row + d[0], col + d[1]);
        }
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertEquals(s.uniquePathsWithObstacles(grid), 2);
        grid = new int[][]{{0, 1}};
        assertEquals(new Solution().uniquePathsWithObstacles(grid), 0);
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
