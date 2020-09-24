package 数组.q59_螺旋矩阵2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int dir[][] = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0},
        };
        int cursor = 0;
        int[] d = dir[cursor];
        int i = 0, j = -1;
        for (int c = 1; c <= n * n; c++) {
            if (!checkNextPos(res, d, i, j)){
                cursor = (cursor + 1) % 4;
                d = dir[cursor];
            }
            i += d[0];
            j += d[1];
            res[i][j] = c;
        }
        return  res;
    }

    /**
     * 判断下一个位置是否合法
     */
    private boolean checkNextPos(int[][] res, int[] d, int i, int j) {
        int nextI = i + d[0];
        int nextJ = j + d[1];
        int rows = res.length, cols = res[0].length;
        return (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && res[nextI][nextJ] == 0);
    }


    public static void main(String[] args) {
        int[][] r = new Solution().generateMatrix(4);
        for (int i = 0; i < r.length; i++) {
            printArray(r[i]);
        }
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
