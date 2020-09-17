package 并查集.q685_冗余连接2;

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
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] res = new Solution().findRedundantDirectedConnection(edges);
        assertArrayEquals(s.findRedundantDirectedConnection(edges), new int[]{2,3});
        edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        assertArrayEquals(s.findRedundantDirectedConnection(edges), new int[]{4,1});
        edges = new int[][]{{1, 2}, {2, 3}, {4, 1}, {3, 4}, {1, 5}};
        assertArrayEquals(s.findRedundantDirectedConnection(edges), new int[]{3, 4});
    }
}
