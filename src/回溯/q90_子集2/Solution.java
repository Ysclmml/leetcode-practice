package 回溯.q90_子集2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        dfs(0, res, tmp, nums);
        return res;
    }

    private void dfs(int index, List<List<Integer>> res, List<Integer> tmp, int[] nums) {
        int len = nums.length;
        if (index == len) return;
        for (int i = index; i < len; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            dfs(i + 1, res, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }

    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                System.out.print(nums[i]);
            } else {
                System.out.print(", " + nums[i]);
            }
        }
        System.out.println("]");
    }
}
