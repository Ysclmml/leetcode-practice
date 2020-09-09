package 哈希表.q1_两数之和;


/**
 * 暴力解法
 * https://leetcode-cn.com/problems/two-sum/
 * create by yscl on 2020/9/8
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}

