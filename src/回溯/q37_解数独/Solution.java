package 回溯.q37_解数独;

/**
 * Solution
 * create by yscl on 2020/9/15
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        boolean row[][] = new boolean[9][9];
        boolean col[][] = new boolean[9][9];
        boolean[][][] line = new boolean[3][3][9];
        // 初始化每一行列的使用情况
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    line[i / 3][j / 3][num] = true;
                }
            }
        }
        sudoku(0, row, col, line, board);
    }

    private boolean sudoku(int n, boolean[][] row, boolean[][] col, boolean[][][] line, char[][] board) {
        if (n == 81) return true;
        int i = n / 9, j = n % 9; // 可以通过当前正在填第n个数, 可以获取当前是第几行第几列
        if (board[i][j] != '.') return sudoku(n + 1, row, col, line, board);
        // 当前表示可以填写, 尝试从1到9填写数字
        for (int num = 0; num < 9; num++) {
            if (!row[i][num] && !col[j][num] && !line[i / 3][j / 3][num]) {
                board[i][j] = (char) ('1' + num);
                row[i][num] = col[j][num] = line[i / 3][j / 3][num] = true;
                boolean flag = sudoku(n + 1, row, col, line, board);
                if (flag) return true;
                board[i][j] = '.';
                row[i][num] = false;
                col[j][num] = false;
                line[i / 3][j / 3][num] = false;
            }
        }
        return false;
    }
}
