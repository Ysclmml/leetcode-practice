package 回溯.q60_第k个排列;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.getPermutation(3, 3), "213");
        assertEquals(s.getPermutation(4, 9), "2314");
        assertEquals(s.getPermutation(4, 24), "4321");
        assertEquals(s.getPermutation(4, 23), "4312");
        assertEquals(s.getPermutation(9, 213424), "634578291");
    }


}
