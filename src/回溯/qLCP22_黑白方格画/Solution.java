package 回溯.qLCP22_黑白方格画;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int paintingPlan(int n, int k) {
        if (k == n * n) return 1;
        if (k == 0) return 1;
        int count = 0;

        for (int M = 0; M < n; M++) {
            for (int N = 0; N < n; N++) {
                if (M * n + N * n - M * N == k) {
                    // 这里需要计算出排列组合的数目, 即C(n, M) * C(n, N)
                    count += C(n, M) * C(n, N);
                }
            }
        }
        return count;
    }

    int C(int n, int m) {
        // 计算C(n,m)
        double res = 1;
        m = n > 2 * m ? m : n - m;  // m取小的那个数 5 * 4 / 2 * 1 = C(5, 2)
        for (int i = 1; i <= m; i++) {
            res *= (double) (n - i + 1) / i;
        }
        return (int) res;
    }

    public static void main(String[] args) {

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
