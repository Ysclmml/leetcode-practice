package 回溯.q40_组合总和2;

import java.util.*;

/**
 * Solution
 * create by yscl on 2020/9/17
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, target, tmp, candidates, 0, res);
        return res;
    }

    void dfs(int cur, int target, List<Integer> tmp, int[] candidates, int index, List<List<Integer>> res) {
        if (cur == target) {
            res.add(new ArrayList<>(tmp));
        } else if (cur > target) {
            return;
        }
        int last = -1;
        for (int i = index; i < candidates.length; i++) {
            // 当下一个数和上面一个数相同时, 跳过
            if (last != -1 && candidates[i] == last) continue;
            if (candidates[i] + cur > target) break;
            else {
                last = candidates[i];
                cur += candidates[i];
                tmp.add(candidates[i]);
                dfs(cur, target, tmp, candidates, i + 1, res);
                cur -= candidates[i];
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists);
        List<List<Integer>> lists2 = new Solution().combinationSum2(new int[]{2, 3, 5}, 8);
        System.out.println(lists2);
    }
}
