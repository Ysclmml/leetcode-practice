package 数组.q75_颜色分类;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    /**
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     */
    public void sortColors(int[] nums) {
        int p = 0, q = nums.length - 1;
        for (int i = 0; i <= q; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p];
                nums[p] = 0;
                p++;
            }
            if (nums[i] == 2) {
                nums[i] = nums[q];
                nums[q] = 2;
                i--;
                q--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Solution().sortColors(nums);
        Solution.printArray(nums);
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
