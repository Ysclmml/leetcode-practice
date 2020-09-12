package 动态规划.q787_K站中转内最便宜的航班;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {
    int n1 = 3;
    int flights1[][] = new int[][] {
        new int[]{0,1,100},
        new int[]{1,2,100},
        new int[]{0,2,500}
    };
    int src1 = 0;
    int dst1 = 2;
    int K1 = 1;

    int n2 = 3;
    int flights2[][] = new int[][] {
            new int[]{0,1,100},
            new int[]{1,2,100},
            new int[]{0,2,500}
    };
    int src2 = 0;
    int dst2 = 2;
    int K2 = 0;

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.findCheapestPrice(n1, flights1, src1, dst1, K1), 200);
        assertEquals(s.findCheapestPrice(n2, flights2, src2, dst2, K2), 500);
    }


}
