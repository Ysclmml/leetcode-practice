package 回溯.qOffer12_矩阵中的路径;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int curLen = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (curLen == word.length() - 1) {
                        return true;
                    }
                    boolean result = dfs(board, visited, i, j, curLen + 1, word);
                    if (result) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int startX, int startY, int curLen, String word) {
        // 竖着的是x, 横是y
        int[][] dire = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : dire) {
            int x = startX + dir[0], y = startY + dir[1];
            if (!checkOutSide(board, x, y)) {
                if (!visited[x][y] && board[x][y] == word.charAt(curLen)) {
                    if (curLen == word.length() - 1) {
                        return true;
                    }
                    visited[x][y] = true;
                    boolean res = dfs(board, visited, x, y, curLen + 1, word);
                    if (res) {
                        return true;
                    }
                    visited[x][y] = false;
                }
            }
        }
        return false;
    }

    private boolean checkOutSide(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        return (x >= m) || (y >= n) || (x < 0) || (y < 0);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "BFCE"));
        System.out.println(new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "BFCESFSDF"));
        System.out.println(new Solution().exist(new char[][]{{'A', 'B', 'C', 'D'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "abcd"));
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
