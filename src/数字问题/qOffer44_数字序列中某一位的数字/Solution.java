package 数字问题.qOffer44_数字序列中某一位的数字;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int findNthDigit(int n) {
        int bitLen = 9;
        int[][] numRange = new int[bitLen][2];
        int last = 0;
        int tmp = 10;
        for (int i = 0; i < bitLen; i++) {
            numRange[i][0] = last;
            numRange[i][1] = last + tmp - 1;
            last = numRange[i][1] + 1;
            tmp = ((int) Math.pow(10, i + 2) - (int) Math.pow(10, i + 1)) * (i + 2);
        }
        numRange[bitLen - 1][1] = Integer.MAX_VALUE;
        // for (int[] num : numRange) {
        //     System.out.println(Arrays.toString(num));
        // }
        for (int i = 0; i < bitLen; i++) {
            int[] range = numRange[i];
            if (n <= range[1]) {
                // 当前位数
                int res = (n - range[0]) / (i + 1);
                int start = (i == 0 ? 0 : (int) Math.pow(10, i));
                res += start;
                int bit = (n - range[0]) % (i + 1);
                return Integer.toString(res).charAt(bit) - '0';
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(3));
        System.out.println(new Solution().findNthDigit(3000));
        System.out.println(new Solution().findNthDigit(115));
        System.out.println(new Solution().findNthDigit(100));
        System.out.println(new Solution().findNthDigit(1000000000));
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
