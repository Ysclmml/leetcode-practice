package 字符串.q9_回文数;

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
        assertTrue(s.isPalindrome(121));
        assertTrue(s.isPalindrome(1001));
        assertFalse(s.isPalindrome(-121));
        assertFalse(s.isPalindrome(10));
    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        assertTrue(s.isPalindrome(121));
        assertTrue(s.isPalindrome(1001));
        assertFalse(s.isPalindrome(-121));
        assertFalse(s.isPalindrome(10));
    }
}
