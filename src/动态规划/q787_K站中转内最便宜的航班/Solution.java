package 动态规划.q787_K站中转内最便宜的航班;

import java.util.Arrays;

/**
 * 动态规划解法
 * create by yscl on 2020/9/12
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int dp[][] = new int[K + 1][n];
        // -1 代表不可达
        int not_reachable = Integer.MAX_VALUE;

        // 初始化
        for (int k = 0; k <= K; k++) {
            Arrays.fill(dp[k], not_reachable);
        }
        for (int[] flight : flights) {
            // flight[0]是src, flight[1]是dst, flight[2]是price
            if (flight[0] == src)
                dp[0][flight[1]] = flight[2];
        }
        // src到src不管经过几站, 最小距离都是0
        for (int k = 0; k <= K; k++)
            dp[k][src] = 0;
        // 经过0站的已经初始化过了, 从至多经过1站开始遍历
        for (int k = 1; k <= K; k++) {
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                // 如果原始src经过k-1站可以到达当前站点s
                if (dp[k - 1][s] != not_reachable) {
                    dp[k][d] = Math.min(dp[k][d], dp[k - 1][s] + p);
                }
            }
        }
        return dp[K][dst] == not_reachable ? -1 : dp[K][dst];
    }
}
