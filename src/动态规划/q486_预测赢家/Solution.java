package 动态规划.q486_预测赢家;

/**
 * 动态规划解法
 * create by yscl on 2020/9/14
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        // 当 `i > j`时, 明显当前数组没有意义了, 所以`dp[i][j] = 0`
        // 当 `i = j`时, 因为当前选手只可以拿一个子了, 所以`dp[i][j] = nums[i]`
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        // 考虑需要使用i+1, 所以从i-2开始, j必须大于i
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
