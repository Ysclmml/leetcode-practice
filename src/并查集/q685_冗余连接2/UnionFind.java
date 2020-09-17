package 并查集.q685_冗余连接2;

/**
 * 并查集
 * create by yscl on 2020/9/17
 */
public class UnionFind {
    private int[] uf;

    public UnionFind(int n) {
        uf = new int[n + 1];
        // 默认分为n个集合, 其实每个root都是自己
        for (int i = 1; i <= n; i++) uf[i] = i;
    }

    /**
     * 查找x的根结点, 边查找边做路径压缩
     * @param x 带查找的根结点
     */
    public int find(int x) {
        // 查找x的根结点
        int p = x;
        if (uf[p] == x) return p;
        // 路径压缩
        this.uf[p] = find(uf[p]);
        return this.uf[p];
    }

    public boolean union(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);
        // 如果两个根结点不相同, 则合并
        if (root1 != root2) {
            uf[root2] = root1;
            return false;
        }
        return true;
    }
}
