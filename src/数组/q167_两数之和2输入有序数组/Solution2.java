package 数组.q167_两数之和2输入有序数组;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution2 {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] res = new int[2];
        int i = 0, j = len - 1;
        while (i <= j) {
            int newTarget = target - numbers[i];
            while (j >= 0 && numbers[j] > newTarget)
                j--;
            if (numbers[j] == newTarget) return new int[]{i + 1, j + 1};
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new Solution2().twoSum(new int[]{2, 7, 11, 15}, 9);
        printArray(ints);
        ints = new Solution2().twoSum(new int[]{2, 7, 11, 15}, 17);
        printArray(ints);
        ints = new Solution2().twoSum(new int[]{2, 7, 11, 11}, 22);
        printArray(ints);
    }

    @Test
    public void testSolution() {
        Solution2 s = new Solution2();
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
