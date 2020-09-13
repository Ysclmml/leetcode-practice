package 回溯.q79_单词搜索;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {
    char[][] board = { {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'} };
    String word = "ABCCED";
    String word1 = "SEE";
    String word2 = "ABCB";
    // [["C","A","A"],["A","A","A"],["B","C","D"]]
    // "AAB"
    char[][] board2 = { {'C','A','A'}, {'A','A','A'}, {'B','C','D'} };
    String word3 = "AAB";

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertTrue(s.exist(board, word));
        assertTrue(s.exist(board, word1));
        assertFalse(s.exist(board, word2));
        assertTrue(s.exist(board2, word3));

    }


}
