package 数组.q219_存在重复元素2;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        Set<Integer> set = new HashSet<>();
        // 队列可以省略, 直接删除nums[i-k]
        // Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            if (set.size() == k) {
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {

    }

    @Test
    public void testSolution() {
        Solution2 s = new Solution2();
        assertTrue(s.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        assertTrue(s.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        assertFalse(s.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
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
