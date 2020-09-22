package 二叉树.q114_二叉树展开为链表;

import org.junit.Test;
import 二叉树.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        travel(root);
    }

    private TreeNode travel(TreeNode root) {
        // 需要返回当前节点的尾节点
        if (root.left == null && root.right == null) return root;
        // 保存当前节点的左节点和右节点引用
        TreeNode tmpLeft = root.left;
        TreeNode tmpRight = root.right;
        if (tmpLeft != null) {
            // 直接把当前节点的右节点指向当前的左节点
            root.right = tmpLeft;
            // 然后当前的左节点置空
            root.left = null;
            // 对以前的左节点做同样的操作, 直到剩最后一个节点, 如果有多个节点, 返回组成链表后的最后一个节点
            TreeNode lastNode = travel(tmpLeft);
            // 原来左边的节点拉直后, 最后一个节点插入到原来的右节点和根结点之间
            lastNode.right = tmpRight;
            // 如果右节点为空, 拉直后的最后一个节点就是刚刚求的最后节点
            if (tmpRight == null) return lastNode;
        }
        // 右边的节点处理方式相同
        return travel(tmpRight);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1, 2, 5, 3, null, 0, 6});
        new Solution().flatten(tree);
        tree.levelTravel();
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }
}
