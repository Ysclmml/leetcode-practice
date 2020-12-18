package 双指针.q18_早餐组合;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        int last = -1;
        for (int i = 0; i < staple.length; i++) {
            if (i > 0 && staple[i] == staple[i - 1]) {
                res = (res + last) % 1000000007;
                continue;
            }
            int index = this.findMaxIndex(drinks, x - staple[i]);
            if (index == -1) break;
            last = index + 1;
            res = (res + last) % 1000000007;
        }
        return res;
    }

    public int findMaxIndex(int[] arr, int target) {
        // 查找不大于某个元素的最大索引
        int left = 0, right = arr.length - 1;
        if (target < arr[0]) return -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left++;
            } else if (arr[mid] == target) {
                while (mid + 1 < arr.length && arr[mid + 1] == target) {
                    mid++;
                }
                return mid;
            } else {
                right--;
            }
        }
        if (left >= arr.length) return arr.length - 1;
        if (arr[left] > target) return left - 1;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxIndex(new int[]{1, 2, 3, 3, 4, 7, 9, 11}, 4));
        System.out.println(new Solution().findMaxIndex(new int[]{1, 2, 3, 3, 4, 7, 9, 11}, 8));
        System.out.println(new Solution().findMaxIndex(new int[]{1, 2, 3, 3, 4, 7, 9, 11}, 0));
        System.out.println(new Solution().findMaxIndex(new int[]{1, 2, 3, 3, 4, 7, 9, 11}, 11));
        System.out.println(new Solution().findMaxIndex(new int[]{1, 2, 3, 3, 4, 7, 9, 11}, 10));
        System.out.println(new Solution().findMaxIndex(new int[]{1, 2, 3, 3,3, 4, 7, 9, 11}, 13));

        System.out.println(new Solution().breakfastNumber(new int[]{2,1,1}, new int[]{8,9,5,1}, 9));
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
