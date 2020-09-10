package 动态规划.q300_最长上升子序列;


/**
 * 时间复杂度 O(nlogn) 动态规划
 * create by yscl on 2020/9/9
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        int len = 1;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len++] = nums[i];
            } else if (nums[i] < dp[len - 1]) {
                // 这里使用二分法来寻找第一个比nums[i]小的dp数组的数的索引
                int left = 0;
                int right = len - 1;
                int mid;
                while (left <= right) {
                    mid = (right + left) / 2;
                    if (nums[i] < dp[mid]) {
                        right = mid - 1;
                    } else if (dp[mid] == nums[i]) {
                        right = mid - 1;
                        break;
                    } else {
                        left = mid + 1;
                    }
                }
                // 最后的right就是第一个比nums[i]小的数的索引
                dp[right + 1] = nums[i];
            }
        }
        return len;
    }
}
