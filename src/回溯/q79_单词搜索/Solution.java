package 回溯.q79_单词搜索;

/**
 * Solution
 * create by yscl on 2020/9/13
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (search(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        // 如果第一个字符就不满足情况, 直接返回false
        if (board[i][j] != word.charAt(k)) return false;
        // 如果已经匹配的字符长度等于word的长度, 则代表已经找到了
        if (k == word.length() - 1) return true;
        // 上右下左方向
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        int h = board.length;
        int w = board[0].length;
        // 先把访问状态置为true
        visited[i][j] = true;
        // 遵循上右下左的方向来进行搜索
        for (int[] dire : directions) {
            int nextI = i + dire[0];
            int nextJ = j + dire[1];
            // 边界检测与查看是否访问过
            if (nextI >= 0 && nextI < h && nextJ >= 0 && nextJ < w && !visited[nextI][nextJ]) {
                boolean flag = search(board, word, nextI, nextJ, k + 1, visited);
                if (flag) return true;
            }
        }
        // 状态复原, 恢复为没访问的状态
        visited[i][j] = false;
        return false;
    }
}
