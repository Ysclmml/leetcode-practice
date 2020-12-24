package 数字问题.q342_4的幂;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    static Set<Integer> nums = new HashSet<>();

    static {
        int n = 1;
        for (int i = 0; i < 16; i++) {
            nums.add(n);
            n <<= 2;
        }
    }

    public boolean isPowerOfFour(int n) {
        // 事先定义好所有的可能性, 然后比较
        return nums.contains(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(16));
        System.out.println(new Solution().isPowerOfFour(5));
        System.out.println(new Solution().isPowerOfFour(1));
        System.out.println(new Solution().isPowerOfFour(-1));
        System.out.println(new Solution().isPowerOfFour((int) Math.pow(4, 15)));
        System.out.println(new Solution().isPowerOfFour((int) Math.pow(4, 15) - 1));
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
