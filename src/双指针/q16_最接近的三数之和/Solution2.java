package 双指针.q16_最接近的三数之和;

import java.util.Arrays;

/**
 * 使用双指针法
 * create by yscl on 2020/9/20
 */
public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        // 对排序数组做处理
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int fix = nums[i];
            int tar = target - fix;
            int left = 0, right = nums.length - 1;
            while (left < right) {
                // 不能等于当前固定的值
                if (left == i) {
                    left++;
                    continue;
                } else if (right == i) {
                    right--;
                    continue;
                }
                int tmp_sum = nums[left] + nums[right];
                int tmp_min = Math.abs(tmp_sum - tar);
                if (tmp_min < min) {
                    min = tmp_min;
                    sum = tmp_sum + fix;
                }
                if (tmp_sum < tar) left++;
                else if (tmp_sum > tar) right--;
                else return sum;
            }
        }
        return sum;
    }
}
