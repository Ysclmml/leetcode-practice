package 回溯.q77_组合;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.addAll;

/**
 * Solution
 * create by yscl on 2020/9/16
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Set<Integer> set = new HashSet<Integer>();
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < k; i++) tmp.add(0);
        solve(set, res, tmp, n, k, 1);
        return res;
    }

    private void solve(Set<Integer> set, List<List<Integer>> res, List<Integer> tmp, int n, int k, int cur) {
        int len = set.size();
        if (len == k) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(tmp);
            res.add(newList);
        } else {
            // 防止重复取值, i的起始位置也开始限制
            for (int i = cur; i <= n; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    tmp.set(len, i);
                    solve(set, res, tmp, n, k, i + 1);
                    set.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combine(4, 2);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
