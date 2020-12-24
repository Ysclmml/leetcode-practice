package 位运算.qOffer_55_数组中数字出现的次数;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {
        int k = 0;
        // 求出最后两个数的总体的异或值
        for (int n : nums) {
            k ^= n;
        }
        int mask = 1;
        // 从最后一位来求出第一位不同的那一位.  因为有两个数不同. 所以最后的异或操作结果是
        // 这两个数的异或的和. 并且这两个数的异或结果一定不为0. 所以必定且至少存在某位不相等
        // 在程序里表示就是求出k中第一位为1的位数.
        while ((k & mask) == 0) {
            mask <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((n & mask) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumbers(new int[]{1, 4, 4, 6})));
        System.out.println(Arrays.toString(new Solution().singleNumbers(new int[]{4, 1, 4, 6})));
        System.out.println(Arrays.toString(new Solution().singleNumbers(new int[]{1,2,5,2})));
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
