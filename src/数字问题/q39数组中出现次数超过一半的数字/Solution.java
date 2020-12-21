package 数字问题.q39数组中出现次数超过一半的数字;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int half = len / 2;
        for (int j : nums) {
            int num = map.getOrDefault(j, 0);
            if (num >= half) {
                return j;
            }
            map.put(j, num + 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(new Solution().majorityElement(new int[]{1, 2, 2, 3, 2}));
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
