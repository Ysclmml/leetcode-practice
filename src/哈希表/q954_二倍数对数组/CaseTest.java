package 哈希表.q954_二倍数对数组;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {
    int[] nums1 = new int[]{3,1,3,6};
    int[] nums2 = new int[]{2,1,2,6};
    int[] nums3 = new int[]{4,-2,2,-4};
    int[] nums4 = new int[]{1,2,4,16,8,4};
    int[] nums5 = new int[]{0, 0, 0, -1, -2, 0};
    int[] nums6 = new int[]{0, 0, 0, -1, -2, 0, 0};

    @Test
    public void testSolution() {

        Solution s = new Solution();
        assertFalse(s.canReorderDoubled(nums1));
        assertFalse(s.canReorderDoubled(nums2));
        assertTrue(s.canReorderDoubled(nums3));
        assertFalse(s.canReorderDoubled(nums4));
        assertTrue(s.canReorderDoubled(nums5));
        assertFalse(s.canReorderDoubled(nums6));
    }

    @Test
    public void testSolution2() {

        Solution2 s = new Solution2();
        assertFalse(s.canReorderDoubled(nums1));
        assertFalse(s.canReorderDoubled(nums2));
        assertTrue(s.canReorderDoubled(nums3));
        assertFalse(s.canReorderDoubled(nums4));
        assertTrue(s.canReorderDoubled(nums5));
        assertFalse(s.canReorderDoubled(nums6));
    }

}
