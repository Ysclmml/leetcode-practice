package 数组.q80_删除排序数组中的重复项2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0 ) return 0;
        int pos = 1;
        int count = 1;  // 统计一个元素必须只出现一次
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count < 2) {
                    count++;
                    nums[pos++] = nums[i];
                } else {
                    // 找到第一个不等于当前数的数, 退出
                    while (++i < len && nums[i] == nums[i - 1]) {}
                    if (i < len) {
                        nums[pos++] = nums[i];
                        count = 1;
                    }
                }
            } else {
                count = 1;
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4};
        System.out.println(new Solution().removeDuplicates(nums));
        printArray(nums);
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(s.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4}), 7);
        assertEquals(s.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4,6}), 8);
        assertEquals(s.removeDuplicates(new int[]{1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4,4}), 7);
        assertEquals(s.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}), 7);
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
