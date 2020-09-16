package 回溯.q77_组合;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 优化第一次的做法, 加上剪枝处理
 * create by yscl on 2020/9/16
 */
public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        solve(res, tmp, n, k, 1);
        return res;
    }

    private void solve(List<List<Integer>> res, List<Integer> tmp, int n, int k, int cur) {
        int len = tmp.size();
        // 当前长度 + [cur, n]区间的长度
        if (len + n - cur + 1 < k) return;
        if (len == k) {
            res.add(new ArrayList<>(tmp));
        } else {
            // // 防止重复取值, i的起始位置也开始限制
            // for (int i = cur; i <= n; i++) {
            //     tmp.add(i);
            //     solve(res, tmp, n, k, i + 1);
            //     // 移除末尾元素
            //     tmp.remove(tmp.size() - 1);
            // }

            // 还可以优化, 这里是做一个剪枝处理
            // 即当当前的长度 tmp.size() + n - cur + 1 > k的时候, 这时候就无需再做递归处理了, 因为超过了k长度, 也不符合条件
            // 而当 tmp.size() + n - cur < k 的时候, 无论如何都无法做出k的长度, 直接返回
            for (int i = cur; i <= n - (k - tmp.size()) + 1; i++) {
                tmp.add(i);
                solve(res, tmp, n, k, i + 1);
                // 移除末尾元素
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution2().combine(4, 2);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
