package 双指针.q16_最接近的三数之和;

import java.util.Arrays;

/**
 * 思路有错误, 如果全部是正整数, 则没问题, 但是含有负数, 所以答案一定不正确
 * create by yscl on 2020/9/20
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 对排序数组做处理
        Arrays.sort(nums);
        int avg = target / 3;
        // 找到avg合适的索引位置
        int index = findIndex(nums, avg);
        return getMinValue(nums, target, index);
    }

    /**
     * 获取index附近3个值之和与target的最小差值
     */
    private int getMinValue(int[] nums, int target, int index) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        for (int i = index - 2; i <= index; i++) {
            if (i < 0 || i + 2 >= len) continue;
            int tmp_sum = nums[i] + nums[i + 1] + nums[i + 2];
            int tmp = Math.abs(tmp_sum - target);
            if (tmp < min) {
                min = tmp;
                sum = tmp_sum;
            }
        }
        return sum;
    }

    private int findIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // System.out.println("left " + left + " right " + right + " target " + target);
        if (right == -1) return 0;
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findIndex(new int[]{-4, -1, -1, 1, 2, 5}, 6));
        System.out.println(new Solution().findIndex(new int[]{-4, -1, -1, 1, 2, 5}, 4));
        System.out.println(new Solution().findIndex(new int[]{-4, -1, -1, 1, 2, 5}, 0));
        System.out.println(new Solution().findIndex(new int[]{-4, -1, -1, 1, 2, 5}, -3));
        System.out.println(new Solution().findIndex(new int[]{-4, -1, -1, 1, 2, 5}, -5));
    }
}
