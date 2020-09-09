package 哈希表.q1_两数之和;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {
    int[] nums1 = new int[]{2, 7, 11, 15};
    int[] nums2 = new int[]{6, 6, 3, 9, 3};

    @Test
    public void testSolution() {

        Solution1 s = new Solution1();
        assertArrayEquals(new int[]{0, 1}, s.twoSum(nums1, 9));
        assertArrayEquals(new int[]{2, 4}, s.twoSum(nums2, 6));
    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        assertArrayEquals(new int[]{0, 1}, s.twoSum(nums1, 9));
        assertArrayEquals(new int[]{2, 4}, s.twoSum(nums2, 6));
    }
}
