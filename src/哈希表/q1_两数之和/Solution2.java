package 哈希表.q1_两数之和;

import java.util.HashMap;

/**
 * 哈希解法
 * create by yscl on 2020/9/8
 */
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           if (map.containsKey(target - nums[i])) {
               result[0] = map.get(target - nums[i]);
               result[1] = i;
               return result;
           } else {
               map.put(nums[i], i);
           }
        }
        return null;
    }
}
