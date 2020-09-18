package 二叉树.q637_二叉树的层平均值;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 * create by yscl on 2020/9/17
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        class LevelNode {
            TreeNode node;
            int level;
             private LevelNode(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        Queue<LevelNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        queue.add(new LevelNode(root, 0));
        int lastLevel = 0;
        double sum = 0;
        int levelNum = 0;
        while (queue.size() != 0) {
            LevelNode node = queue.poll();
            if (lastLevel != node.level) {
                lastLevel = node.level;
                res.add(sum / levelNum);
                sum = node.node.val;
                levelNum = 1;
            } else {
                sum += node.node.val;
                levelNum++;
            }
            if (node.node.left != null) queue.add(new LevelNode(node.node.left, node.level + 1));
            if (node.node.right != null) queue.add(new LevelNode(node.node.right, node.level + 1));
        }
        res.add(sum / levelNum);
        return res;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 9, 20, 15, 7});
        System.out.println(new Solution().averageOfLevels(tree));
    }
}
