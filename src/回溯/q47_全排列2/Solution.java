package 回溯.q47_全排列2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 * create by yscl on 2020/9/18
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, tmp, res, visited);
        return res;
    }

    private void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> res, boolean[] visited) {
        int len = nums.length;
        if (tmp.size() == len) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        Integer last = null;
        for (int i = 0; i < len; i++) {
            if (new Integer(nums[i]).equals(last) || visited[i]) continue;
            tmp.add(nums[i]);
            visited[i] = true;
            last = nums[i];
            dfs(nums, tmp, res, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }
}
