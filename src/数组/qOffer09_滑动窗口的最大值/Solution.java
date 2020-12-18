package 数组.qOffer09_滑动窗口的最大值;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return nums;
        int[] res = new int[len - k + 1];
        int max = nums[0];
        int maxIndex = 0; // 记录最大值所在的索引.
        for (int i = 1; i < k; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        res[0] = max;
        for (int i = k, j = 1; i < len; i++, j++) {
            // 之前的最大值在当前滑动窗口内
            if (maxIndex > i - k) {
                if (nums[i] >= res[j - 1]) {
                    maxIndex = i;
                    res[j] = nums[i];
                } else {
                    res[j] = res[j - 1];
                }
            } else {
                // 重新计算最大值
                maxIndex = i - k + 1; // 记录最大值所在的索引.
                max = nums[maxIndex];
                for (int m = i - k + 1; m <= i; m++) {
                    if (nums[m] >= max) {
                        max = nums[m];
                        maxIndex = m;
                    }
                }
                res[j] = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5)));
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
