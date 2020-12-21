package 数组.q228_汇总区间;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] == max + 1) {
                    res.add(min + "->" + nums[i]);
                } else {
                    if (min == max) {
                        res.add(Integer.toString(min));
                    } else {
                        res.add(min + "->" + max);
                    }
                    res.add(Integer.toString(nums[i]));
                }
            }
            else if (nums[i] != max + 1) {
                if (min == max) {
                    res.add(Integer.toString(min));
                } else {
                    res.add(min + "->" + max);
                }
                min = max = nums[i];
            } else {
                max++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(new Solution().summaryRanges(new int[]{7}));
        System.out.println(new Solution().summaryRanges(new int[]{}));
        System.out.println(new Solution().summaryRanges(new int[]{0,2,4,5,7,10}));
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
