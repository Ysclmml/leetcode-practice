package 数字问题.q61_扑克牌中的顺子;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        int[] visited = new int[14];
        Arrays.sort(nums);
        int min, max = 4;
        int i = 0;
        while (i < nums.length && nums[i] == 0){
            i++;
            visited[0]++;
        }
        min = i;
        for (; i < nums.length; i++) {
            int n = nums[i];
            // 出现重复
            if (visited[n] > 0) return false;
            visited[n]++;
        }
        // 判断范围是否合适
        return nums[max] - nums[min] <= 4;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().isStraight(new int[]{1, 2, 5, 0, 0}));
        System.out.println(new Solution().isStraight(new int[]{1, 2, 5, 13, 0}));
        System.out.println(new Solution().isStraight(new int[]{1, 2, 5, 4, 0}));
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
