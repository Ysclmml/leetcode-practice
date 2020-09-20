package 双指针.q16_最接近的三数之和;

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
        assertEquals(s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2);
        assertEquals(s.threeSumClosest(new int[]{0,1,2}, 0), 3);
        assertEquals(s.threeSumClosest(new int[]{0,2,1,-3}, 1), 0);
    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        assertEquals(s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2);
        assertEquals(s.threeSumClosest(new int[]{0,1,2}, 0), 3);
        assertEquals(s.threeSumClosest(new int[]{0,2,1,-3}, 1), 0);
    }

}
