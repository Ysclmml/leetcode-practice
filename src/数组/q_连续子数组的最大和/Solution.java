package 数组.q_连续子数组的最大和;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int tmp = Math.max(max, 0);
        for (int i = 1; i < len; i++) {
            if (nums[i] < 0) {
                if (max < nums[i]) {
                    max = nums[i];
                    tmp = 0;
                } else {
                    if (tmp + nums[i] > 0) {
                        tmp += nums[i];
                    } else {
                        tmp = 0;
                    }
                }
            } else {
                tmp += nums[i];
                if (max < tmp) max = tmp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray(new int[]{1,2}));
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1}));
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
