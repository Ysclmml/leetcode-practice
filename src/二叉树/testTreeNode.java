package 二叉树;

/**
 * testTreeNode
 * create by yscl on 2020/9/14
 */
public class testTreeNode {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1, null, 2, 3});
        if (tree != null) {
            tree.levelTravel();
        }
    }
}
