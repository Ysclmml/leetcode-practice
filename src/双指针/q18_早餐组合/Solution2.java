package 双指针.q18_早餐组合;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution2 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        int right = drinks.length - 1;
        for (int i = 0; i < staple.length; i++) {
            while (right >= 0 && staple[i] + drinks[right] > x) {
                right--;
            }
            if (right < 0) break;
            res = (res + right + 1) % 1000000007;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().breakfastNumber(new int[]{2,1,1}, new int[]{8,9,5,1}, 9));
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
