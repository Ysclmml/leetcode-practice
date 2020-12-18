package 双指针.q21_调整数组顺序使奇数位于偶数前面;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int p = 0, q = nums.length - 1;
        if (nums.length == 0) return nums;
        while (p != q) {
            while (p < q && nums[p] % 2 != 0) {
                p++;
            }
            while (p < q && nums[q] % 2 == 0) {
                q--;
            }
            if (p < q) {
                int tmp = nums[p];
                nums[p] = nums[q];
                nums[q] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{2, 1,5,0,6,9,1,3, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{2,1})));
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
