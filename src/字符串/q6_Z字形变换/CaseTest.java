package 字符串.q6_Z字形变换;

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
        assertEquals(s.convert("LEETCODEISHIRING", 3), "LCIRETOESIIGEDHN");
        assertEquals(s.convert("LEETCODEISHIRING", 4), "LDREOEIIECIHNTSG");
        assertEquals(s.convert("G", 1), "G");
        assertEquals(s.convert("", 5), "");
        assertEquals(s.convert("ABCDE", 4), "ABCED");
    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        assertEquals(s.convert("LEETCODEISHIRING", 3), "LCIRETOESIIGEDHN");
        assertEquals(s.convert("LEETCODEISHIRING", 4), "LDREOEIIECIHNTSG");
        assertEquals(s.convert("G", 1), "G");
        assertEquals(s.convert("", 5), "");
        assertEquals(s.convert("ABCDE", 4), "ABCED");
    }
}
