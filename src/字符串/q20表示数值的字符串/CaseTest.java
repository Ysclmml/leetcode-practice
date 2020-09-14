package 字符串.q20表示数值的字符串;

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
        String str = "0";
        assertTrue(s.isNumber(str));
        str = "+100";
        assertTrue(s.isNumber(str));
        str = "5e2";
        assertTrue(s.isNumber(str));
        str = "-123";
        assertTrue(s.isNumber(str));
        str = "3.1416";
        assertTrue(s.isNumber(str));
        str = "-1E-16";
        assertTrue(s.isNumber(str));
        str = "0123";
        assertTrue(s.isNumber(str));
        str = "12e";
        assertFalse(s.isNumber(str));
        str = "1a3.14";
        assertFalse(s.isNumber(str));
        str = "1.2.3";
        assertFalse(s.isNumber(str));
        str = "+-5";
        assertFalse(s.isNumber(str));
        str = "12e+5.4";
        assertFalse(s.isNumber(str));
        str = "1 ";
        assertTrue(s.isNumber(str));
        str = ".1";
        assertTrue(s.isNumber(str));
        str = "1.";
        assertTrue(s.isNumber(str));
    }
}
