package 动态规划.q978_最长湍流子数组;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {
    int[] num1 = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
    int[] num2 = new int[]{4,8,12,16};
    int[] num3 = new int[]{100};
    int[] num4 = new int[]{9, 4, 4, 10, 7, 8, 8, 1, 9};


    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.maxTurbulenceSize(num1), 5);
        assertEquals(s.maxTurbulenceSize(num2), 2);
        assertEquals(s.maxTurbulenceSize(num3), 1);
        assertEquals(s.maxTurbulenceSize(num4), 4);
    }


}
