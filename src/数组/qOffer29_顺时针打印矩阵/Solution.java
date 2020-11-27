package 数组.qOffer29_顺时针打印矩阵;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1;
        int[] res = new int[(r + 1) * (b + 1)];
        int x = 0;
        while (true) {
            // 左->右
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) break;
            // 上 -> 下
            for (int i = t; i <= b; i++) {
                res[x++]  = matrix[i][r];
            }
            if (--r < l) break;
            // 右 -> 左
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (--b < t) break;
            // 下 -> 上
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return res;
    }

    public static void main(String[] args) {

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
