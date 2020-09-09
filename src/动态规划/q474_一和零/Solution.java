package 动态规划.q474_一和零;

/**
 * Solution
 * create by yscl on 2020/9/9
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (String str :strs) {
            int count[] = countZeroOnes(str);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - count[0]][j - count[1]]);
                }
            }
        }
        return dp[m][n];
    }

    public int[] countZeroOnes(String str) {
        // 统计0和1的个数返回一个01个数的数组
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}
