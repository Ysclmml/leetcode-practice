package 数字问题.q15_二进制中1的个数;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 0x01) == 1) res++;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(9));
        System.out.println(new Solution().hammingWeight(0));
        System.out.println(new Solution().hammingWeight(15));
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
