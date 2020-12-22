package 动态规划.qOffer63_股票的最大利润;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int maxProfit(int[] prices) {
        // 以下解法是可以买入卖出无数次后的最大结果.
        // int[][] dp = new int[2][prices.length];
        // if (prices.length == 0) return 0;
        // dp[0][0] = -prices[0];
        // dp[1][0] = 0;
        // for (int i = 1; i < prices.length; i++) {
        //     dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] - prices[i]);
        //     dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + prices[i]);
        // }
        // return dp[1][prices.length - 1];

        // 现在只需要交易一次. 这就需要求出这个数组中的最大的差值.
        int len = prices.length;
        if (len == 0) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
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
