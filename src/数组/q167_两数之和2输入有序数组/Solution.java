package 数组.q167_两数之和2输入有序数组;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            int j = binarySearch(numbers, target - numbers[i], i + 1);
            if (j != -1) return new int[]{i + 1, j + 1};
        }
        return res;
    }

    private int binarySearch(int[] numbers, int target, int start) {
        int right = numbers.length - 1;
        if (start > right || target < numbers[start] || target > numbers[right]) return -1;
        int left = start;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] < target) left = mid + 1;
            else if (numbers[mid] == target) return mid;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        printArray(ints);
        ints = new Solution().twoSum(new int[]{2, 7, 11, 15}, 17);
        printArray(ints);
        ints = new Solution().twoSum(new int[]{2, 7, 11, 11}, 22);
        printArray(ints);
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
