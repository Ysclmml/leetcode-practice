package 二叉树.q94_二叉树的中序遍历;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.assertArrayEquals;


/**
 * CaseTest
 * create by yscl on 2020/9/8
 */

public class CaseTest {

    @Test
    public void testSolution() {
        Solution s = new Solution();
        TreeNode tree = TreeNode.createTree(new Integer[]{1, null, 2, 3});
        assertArrayEquals(s.inorderTraversal(tree).toArray(), new Integer[]{1, 3, 2});
    }

    @Test
    public void testSolution2() {
        Solution2 s = new Solution2();
        TreeNode tree = TreeNode.createTree(new Integer[]{1, null, 2, 3});
        assertArrayEquals(s.inorderTraversal(tree).toArray(), new Integer[]{1, 3, 2});
    }


}
