package 回溯.q216_组合总和3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 * create by yscl on 2020/9/17
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(0, n, tmp, 1, k,  res);
        return res;
    }

    void dfs(int cur, int target, List<Integer> tmp, int index, int k,  List<List<Integer>> res) {
        if (cur == target && k == tmp.size()) {
            res.add(new ArrayList<>(tmp));
        } else if (cur > target || cur + index * (k - tmp.size()) > target) {
            return;
        }
        for (int i = index; i <=9 && i <= target - cur; i++) {
            // 当下一个数和上面一个数相同时, 跳过
            if (i + cur > target) break;
            else {
                cur += i;
                tmp.add(i);
                dfs(cur, target, tmp,i + 1, k, res);
                cur -= i;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum3(3, 7);
        System.out.println(lists);
        List<List<Integer>> lists2 = new Solution().combinationSum3(3, 9);
        System.out.println(lists2);
        List<List<Integer>> lists3 = new Solution().combinationSum3(2, 18);
        System.out.println(lists3);
    }
}
