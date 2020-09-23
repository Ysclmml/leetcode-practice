package 数组.q120_三角形最小路径和;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 1) return triangle.get(0).get(0);
        int[] dp = new int[rows];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < rows; i++) {
            int first = dp[0];
            int second = dp[1];
            dp[0] += triangle.get(i).get(0);
            for (int j = 1; j <= i; j++) {
                int tmp = Math.min(first, second) + triangle.get(i).get(j);
                first = second;
                if (j < rows - 1) second = dp[j + 1];
                dp[j] = tmp;
            }
        }
        int min = dp[0];
        for (int i = 1; i < rows; i++) {
            if (min > dp[i]) {
                min = dp[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3,4),
            Arrays.asList(6,5,7),
            Arrays.asList(4,1,8,3)
        );
        assertEquals(s.minimumTotal(triangle), 11);
    }
}
