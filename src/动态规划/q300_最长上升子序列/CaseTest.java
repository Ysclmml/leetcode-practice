package 动态规划.q300_最长上升子序列;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {
    private int[] nums1 = new int[]{10,9,2,5,3,7,101,18};
    private int[] nums2 = new int[]{1,10,9,2,5,3,7,101,18};
    private int[] nums3 = new int[]{2, 2};

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.lengthOfLIS(nums1), 4);
        assertEquals(s.lengthOfLIS(nums2), 5);
        assertEquals(s.lengthOfLIS(nums3), 1);
    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        assertEquals(s.lengthOfLIS(nums1), 4);
        assertEquals(s.lengthOfLIS(nums2), 5);
        assertEquals(s.lengthOfLIS(nums3), 1);
    }

}
