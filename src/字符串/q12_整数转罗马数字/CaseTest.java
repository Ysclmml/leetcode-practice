package 字符串.q12_整数转罗马数字;

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
        assertEquals(s.intToRoman(3), "III");
        assertEquals(s.intToRoman(4), "IV");
        assertEquals(s.intToRoman(9), "IX");
        assertEquals(s.intToRoman(58), "LVIII");
        assertEquals(s.intToRoman(1994), "MCMXCIV");
    }

}
