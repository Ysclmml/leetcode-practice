package 数组.q135_分发糖果;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int candy(int[] ratings) {
        List<Integer> points = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int len = ratings.length;
        if (len == 0) return 0;
        points.add(0);
        for (int i = 1; i < len - 1; i++) {
            int pre = ratings[i - 1], cur = ratings[i], next = ratings[i + 1];
            if (cur > pre && cur >= next) {
                // 极大值
                points.add(i);
                set.add(i);
            } else if (cur < pre && cur <= next) {
                // 极小值
                points.add(i);
            }
        }
        // 这样求出了所有的拐点.
        points.add(len - 1);
        // 根据拐点计算所有的值.
        System.out.println(points);
        System.out.println(set);
        return 0;
    }

    public static void main(String[] args) {
        // 拐点 [0, 1, 3, 4, 6]
        /*
        * 计算方式: 根据极大值来求. 极大值是 索引 1 , 3
        * 1 + 2 + 1 + 2 +
        * */
        new Solution().candy(new int[]{1,2,2,3,1,1,0});

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
