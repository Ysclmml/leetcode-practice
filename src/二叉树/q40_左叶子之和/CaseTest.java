package 二叉树.q40_左叶子之和;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.assertEquals;


/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {

    @Test
    public void testSolution() {
        Solution s = new Solution();
        TreeNode tree = TreeNode.createTree(new Integer[]{3,9,20,null,null,15,7});
        assertEquals(s.sumOfLeftLeaves(tree), 24);
    }

}
