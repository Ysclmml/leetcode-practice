package 数组.q454_四数相加2;

import com.sun.org.glassfish.external.statistics.CountStatistic;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 先统计第一个数的个数
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        int[][] counts = new int[3][];
        counts[0] = B;
        counts[1] = C;
        counts[2] = D;
        // 然后将上面map产生的键和新的数组B组成笛卡尔积相加, 组成新的map
        for (int[] count : counts) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for (int i = 0; i < count.length; i++) {
                for (Integer key : map.keySet()) {
                    newMap.put(key + count[i], newMap.getOrDefault(key + count[i], 0) + map.get(key));
                }
            }
            map = newMap;
        }
        return map.getOrDefault(0, 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fourSumCount(new int[]{1}, new int[]{-1}, new int[]{0}, new int[]{1}));
        System.out.println(s.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        System.out.println(map.get(2));
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
