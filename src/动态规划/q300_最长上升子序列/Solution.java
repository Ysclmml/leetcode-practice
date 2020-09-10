package 动态规划.q300_最长上升子序列;

/**
 * 时间复杂度 O(n^2) 动态规划
 * create by yscl on 2020/9/9
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[i] = 1;
        int max = nums.length > 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
