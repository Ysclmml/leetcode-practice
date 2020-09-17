package 回溯.q39_组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 * create by yscl on 2020/9/16
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] + cur > target) break;
            else {
                cur += candidates[i];
                tmp.add(candidates[i]);
                dfs(cur, target, tmp, candidates, i, res);
                cur -= candidates[i];
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
        List<List<Integer>> lists2 = new Solution().combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists2);
    }
}
