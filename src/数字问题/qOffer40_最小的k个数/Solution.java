package 数字问题.qOffer40_最小的k个数;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        // 创建大根堆
        if (arr.length == 0 || k == 0) return new int[]{};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, (o1, o2) -> o2 - o1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        maxHeap.addAll(list);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getLeastNumbers(new int[]{3, 2, 1}, 2)));
        System.out.println(Arrays.toString(new Solution().getLeastNumbers(new int[]{}, 0)));
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
