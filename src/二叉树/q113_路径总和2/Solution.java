package 二叉树.q113_路径总和2;

import org.junit.Test;
import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        travel(root, sum, 0, res, new ArrayList<Integer>());
        return res;
    }

    private void travel(TreeNode root, int target, int cur, List<List<Integer>> res, List<Integer> tmp) {
        cur += root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == cur) {
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
                return;
            }
        }
        if (root.left != null) {
            travel(root.left, target, cur, res, tmp);
        }
        if (root.right != null) {
            travel(root.right, target, cur, res, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().pathSum(TreeNode.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1,null,0, null,0}), 22);
        System.out.println(lists);
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
    }
}
