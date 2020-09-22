package 数组.q35_搜索插入位置;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Solution
 * create by yscl on 2020/9/22
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {

        Solution s = new Solution();
        assertEquals(s.searchInsert(new int[]{1,3,5,6}, 5), 2);
        assertEquals(s.searchInsert(new int[]{1,3,5,6}, 2), 1);
        assertEquals(s.searchInsert(new int[]{1,3,5,6}, 7), 4);
        assertEquals(s.searchInsert(new int[]{1,3,5,6}, 0), 0);
    }
}
