package 堆.q347_前K个高频元素;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {


    @Test
    public void testSolution() {
        Solution s = new Solution();
        int[] nums1;
        nums1 = new int[]{1,1,1,2,2,3};
        // assertArrayEquals(s.topKFrequent(nums1, 2), new int[]{1, 2});
        // nums1 = new int[]{1};
        // assertArrayEquals(s.topKFrequent(nums1, 1), new int[]{1});
        nums1 = new int[]{4,1,-1,2,-1,2,3};
        assertArrayEquals(s.topKFrequent(nums1, 2), new int[]{-1, 2});
    }

}
