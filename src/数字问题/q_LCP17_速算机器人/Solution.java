import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public static void main(String[] args) {

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
