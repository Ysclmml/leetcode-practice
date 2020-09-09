package 动态规划.q474_一和零;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {
    String[] strs1 = new String[]{"10", "0001", "111001", "1", "0"};
    int m1 = 5;
    int n1 = 3;
    String[] strs2 = new String[]{"10", "1", "0"};
    int m2 = 1;
    int n2 = 1;

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.findMaxForm(strs1, m1, n1), 4);
        assertEquals(s.findMaxForm(strs2, m2, n2), 2);
    }


}
