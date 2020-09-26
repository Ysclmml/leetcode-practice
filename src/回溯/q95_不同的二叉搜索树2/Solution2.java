package 回溯.q95_不同的二叉搜索树2;

import org.junit.Test;
import 二叉树.TreeNode;
import 双指针.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 自己思路错误, 陷入误区, 直接参考官方题解
 * create by yscl on 2020/9/22
 */
public class Solution2 {
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return dfs(1, n);
    }

    /**
     * 将复杂的问题变为一个个简单的子问题,
     */
    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null); // 加null是为了后面遍历可以少两遍判断. 不然还需要判断左树数组是否为空, 右树是否为空.
            return res;
        }
        // 轮询每一个根结点, 尝试让每一个数都称为根结点, 最后拼接左右子树即可
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = dfs(start, i - 1);
            List<TreeNode> rightTrees = dfs(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution2 s = new Solution2();
        assertEquals("", "");
    }

    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                System.out.print(nums[i]);
            } else {
                System.out.print(", " + nums[i]);
            }
        }
        System.out.println("]");
    }
}
