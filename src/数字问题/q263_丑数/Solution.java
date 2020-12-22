package 数字问题.q263_丑数;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        int[] facts = new int[]{2, 3, 5};
        for (int fact : facts) {
            while (num % fact == 0) {
                num = num / fact;
                if (num == 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(1));
        System.out.println(new Solution().isUgly(0));
        System.out.println(new Solution().isUgly(8));
        System.out.println(new Solution().isUgly(82));
        System.out.println(new Solution().isUgly(81));
        System.out.println(new Solution().isUgly(6));
        System.out.println(new Solution().isUgly(14));
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
