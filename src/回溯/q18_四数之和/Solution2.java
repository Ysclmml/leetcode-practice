package 回溯.q18_四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法1效率十分低, 时间复杂度为O(n^4), 当前方法为参考题解的时间复杂度为O(n^3)的双指针的解法
 * create by yscl on 2020/9/20
 */
public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        // 需要使用4个指针p, q, i, j来表示4数和, 相当于固定2个数, 用剩下的两个指针来求值
        for (int p = 0; p < len - 3; p++) {
            // 需要做去重处理
            if (p > 0 && nums[p] == nums[p - 1]) continue;
            // 剪枝处理, 当前的最小值大于target或当前的最大值小于target的话, 直接返回
            if (nums[p] + nums[p + 1] + nums[p + 2] + nums[p + 3] > target) continue;
            if (nums[p] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) continue;
            for (int q = p + 1; q < len - 2; q++) {
                // 需要做去重处理
                if (q > p + 1 && nums[q] == nums[q - 1]) continue;
                // 剪枝处理, 当前的最小值大于target或当前的最大值小于target的话, 直接返回
                if (nums[p] + nums[q] + nums[q + 1] + nums[q + 2] > target) continue;
                if (nums[p] + nums[q] + nums[len - 2] + nums[len - 1] < target) continue;

                // 开始双指针处理
                int i = q + 1, j = len - 1;
                int tmp_sum = nums[p] + nums[q];
                while (i < j) {
                    if (tmp_sum + nums[i] + nums[j] > target) {
                        j--;
                    } else if (tmp_sum + nums[i] + nums[j] < target) {
                        i++;
                    } else {
                        res.add(Arrays.asList(nums[p], nums[q], nums[i], nums[j]));
                        // 去重处理
                        i++;
                        j--;
                        while (nums[i] == nums[i - 1] && i < j) i++;
                        while (nums[j] == nums[j + 1] && i < j) j--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution2().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
        lists = new Solution2().fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
        System.out.println(lists);
        lists = new Solution2().fourSum(new int[]{0, 0, 0, 0},  0);
        System.out.println(lists);
    }
}
