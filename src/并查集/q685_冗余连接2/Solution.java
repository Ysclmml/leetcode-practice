package 并查集.q685_冗余连接2;

/**
 * Solution
 * create by yscl on 2020/9/17
 */
public class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // 创建一个parent[]数组, 来代表当前节点时候已经有了父节点
        int n = edges.length;
        int[] parent = new int[n + 1];
        UnionFind uf = new UnionFind(n);
        int[][] confict = null;
        int[] last = null;
        for (int i = 0; i < n + 1; i++) parent[i] = i;
        for (int[] edge : edges) {
            int start = edge[0], end = edge[1];
            // 代表入度为2
            if (parent[end] != end) {
                // 记录下当前的问题节点
                confict = new int[2][2];
                confict[0] = new int[]{parent[end], end};
                // 后访问的边
                confict[1] = new int[]{start, end};
            } else {
                parent[end] = start;
                // 合并root, 如果两个根结点相同, 说明已经重复了, 当前就是问题节点
                if (uf.union(start, end)) {
                    last = new int[]{start, end};
                }
            }
        }
        if (confict == null) {
            return last;
        }
        // 去除掉后导致冲突的边后没有环路发生
        return last == null ? confict[1] : confict[0];
    }
}
