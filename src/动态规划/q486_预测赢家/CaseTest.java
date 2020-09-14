package 动态规划.q486_预测赢家;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {

    @Test
    public void testSolution() {
        Solution s = new Solution();
        int[] nums = {1, 5, 2};
        assertFalse(s.PredictTheWinner(nums));
        nums = new int[]{1, 5, 233, 7};
        assertTrue(s.PredictTheWinner(nums));
    }


}
