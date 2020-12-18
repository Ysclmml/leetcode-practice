package 数组.q153寻找旋转排序数组中的最小值;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int findMin(int[] nums) {
        // 参考官方题解的评论区的解法
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // mid可能是最小值
                right = mid;
            } else {
                // mid肯定再mid的右侧
                left = mid + 1;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{3,4,5,6,7,8,9,1,2}));
        System.out.println(new Solution().findMin(new int[]{5,1,2,3,4}));
        System.out.println(new Solution().findMin(new int[]{2,3,4,5,1}));
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
