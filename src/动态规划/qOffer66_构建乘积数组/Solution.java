package 动态规划.qOffer66_构建乘积数组;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        if (len == 0) return res;
        int[][] dp = new int[2][len];
        dp[0][0] = 1;
        dp[1][len - 1] = 1;
        for (int i = 1; i < len; i++) {
            dp[0][i] = dp[0][i-1] * a[i-1];
        }
        for (int i = len - 2; i >= 0; i--) {
            dp[1][i] = dp[1][i + 1] * a[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = dp[0][i] * dp[1][i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructArr(new int[]{1, 2, 3, 4, 5})));
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
