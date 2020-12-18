package 数字问题.qOffer53_II_缺失的数字;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left++;
            } else {
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{0,1,3}));
        System.out.println(new Solution().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
        System.out.println(new Solution().missingNumber(new int[]{1,2,3,4,5,6,7, 8, 9}));
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
