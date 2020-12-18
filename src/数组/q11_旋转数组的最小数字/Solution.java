package 数组.q11_旋转数组的最小数字;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int minArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // mid可能是最小值
                right = mid;
            } else if (nums[mid] == nums[right]) {
                // 先往右找到第一个不重复的数
                int t = mid + 1;
                while (t < right && nums[t] == nums[right]) {
                    t++;
                }
                if (t == right || nums[t] > nums[right]) {
                    right = mid;
                } else {
                    left = t;
                }

            } else {
                // mid肯定再mid的右侧
                left = mid + 1;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[]{3,4,5,6,7,8,9,1,2}));
        System.out.println(new Solution().minArray(new int[]{6,7,8,9,1,2,3,4,5}));
        System.out.println(new Solution().minArray(new int[]{6,7,8,9,10,0,1,2,3,4,5}));
        System.out.println(new Solution().minArray(new int[]{6,7,8,9,10,0}));
        System.out.println(new Solution().minArray(new int[]{0,6,7,8,9,10}));
        System.out.println(new Solution().minArray(new int[]{2,2,2,0,1}));
        System.out.println(new Solution().minArray(new int[]{3,3,1,3}));
        System.out.println(new Solution().minArray(new int[]{1,3,3}));
        System.out.println(new Solution().minArray(new int[]{2,2,2,2,2,2,2,2,2,2,3, 2}));
        System.out.println(new Solution().minArray(new int[]{2,2,2,2,2,2,2,2,2,2,1,2, 2}));
        System.out.println(new Solution().minArray(new int[]{2,2,1,2,2,2,2,2}));
        System.out.println(new Solution().minArray(new int[]{2,2,3,2,2,2,2,2}));
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
