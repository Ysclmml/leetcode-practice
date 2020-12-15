package 动态规划.q青蛙跳台阶问题;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int numWays(int n) {
        // 可以转换为feibonaqie数列问题, 求f(n)
        if (n == 0 || n == 1) return 1;
        int f0 = 1, f1 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = f0 + f1;
            f0 = f1;
            f1 = tmp;
            if (i >= 21) {
                f0 = f0 % 1000000007;
                f1 = f1 % 1000000007;
            }
        }
        return f1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(100));
        System.out.println(solution.numWays(7));
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
