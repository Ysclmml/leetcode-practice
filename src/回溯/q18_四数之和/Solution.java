package 回溯.q18_四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution
 * create by yscl on 2020/9/20
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, 0, target, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int index, int cur, int target, int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == 4) {
            if (cur == target)
                res.add(new ArrayList<>(tmp));
            return;
        }
        Integer last = null;
        for (int i = index; i < nums.length; i++) {
            if (new Integer(nums[i]).equals(last)) {
                continue;
            } else {
                last = nums[i];
            }
            cur += nums[i];
            // 如果下一个是正整数且当前已经大于target了, 则无需继续递归
            if (i + 1 < nums.length && nums[i + 1] >= 0 && cur > target) break;
            tmp.add(nums[i]);
            dfs(i + 1, cur, target, nums, tmp, res);
            cur -= nums[i];
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
        lists = new Solution().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
        System.out.println(lists);
    }
}
