package 回溯.q51_n皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯法
 * create by yscl on 2020/9/14
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] pos = new int[n];
        List<List<String>> result = new ArrayList<>();
        Arrays.fill(pos, -1);
        findPlace(pos, 0, n, result);
        return result;
    }

    /**
     * 递归的寻找位置
     * @param pos 存放当前皇后的位置
     * @param i 当前遍历在第几行
     * @param n 皇后的总数
     * @param result 存储结果
     */
    private void findPlace(int[] pos, int i, int n, List<List<String>> result) {
        if (i == n) {
            // 符合条件, 添加到result数组中
            List<String> list = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    if (k == pos[row]) sb.append("Q");
                    else sb.append(".");
                }
                list.add(sb.toString());
            }
            result.add(list);
        }
        // j表示列, 当前皇后从第0个开始摆放
        for (int j = 0; j < n; j++) {
            // check当前位置是否合法
            int cur = i - 1;
            for (; cur >= 0; cur--) {
                // 比较列
                if (j == pos[cur]) break;
                // 比较斜线
                if (Math.abs(cur - i) == Math.abs(j - pos[cur])) break;
            }
            // 说明当前位置是合法的
            if (cur < 0) {
                pos[i] = j;
                findPlace(pos, i + 1, n, result);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
        lists = new Solution().solveNQueens(8);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
