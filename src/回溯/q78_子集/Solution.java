package 回溯.q78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 * create by yscl on 2020/9/20
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        res.add(new ArrayList<>());
        solve(nums, 0, res, tmp);
        return res;
    }

    private void solve(int[] nums, int index, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == nums.length) return;
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            solve(nums, i + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(lists);
    }
}
