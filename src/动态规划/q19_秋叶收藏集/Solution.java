package 动态规划.q19_秋叶收藏集;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int minimumOperations(String leaves) {
        return getOperations(leaves);
    }

    int getOperations(String leaves) {
        int len = leaves.length();
        int[][] dp = new int[2][len];
        dp[0][0] = 0;
        dp[1][0] = 99999999;
        int first = leaves.charAt(0) == 'r' ? 0 : 1;
        // 统计出结尾全部替换成r需要操作的次数
        int[] operations = new int[len];
        operations[len - 1] = leaves.charAt(len - 1) == 'y' ? 1 : 0;
        for (int i = len - 2; i >= 2; i--) {
            operations[i] = (leaves.charAt(i) == 'r' ? 0 : 1) + operations[i + 1];
        }

        int lastIdx = len - 2;
        for (int i = 1; i < lastIdx; i++) {
            dp[0][i] = dp[0][i - 1] + (leaves.charAt(i) == 'r' ? 0 : 1);
            dp[1][i] = Math.min(dp[1][i - 1], dp[0][i - 1]) + (leaves.charAt(i) =='r' ? 1 : 0);
        }
        dp[1][lastIdx] = Math.min(dp[1][lastIdx - 1], dp[0][lastIdx - 1]) + (leaves.charAt(lastIdx) =='r' ? 1 : 0);

        int min = 9999999;
        for (int i = 1; i < len - 1; i++) {
            min = Math.min(dp[1][i] + operations[i + 1], min);
        }

        return min + first;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations("ryyryyyrryyyyyryyyrrryyyryryyyyryyrrryryyyryrryrrrryyyrrrrryryyrrrrryyyryyryrryryyryyyyryyrryrryryy"));
        System.out.println(new Solution().minimumOperations("ryyyrrrryrryyyyrrryrryyyryrryryyrryyyryyryyyyryrrryryyryrryyryryryrryyrryyyryrrryryryrrrryrrrrrryry"));
        System.out.println(new Solution().minimumOperations("yyryrryrryyryyyyryyryrryryyryyyrrrrryyryrrrrryyyrrrryrryryyyryrrryyryyyyryryyyrrryyyryyyyyrryyyryyr"));
        System.out.println(new Solution().minimumOperations("rrryyyrryyyrr"));
        System.out.println(new Solution().minimumOperations("rrryyyyyrrrryyyrr"));
        System.out.println(new Solution().minimumOperations("ryr"));
        System.out.println(new Solution().minimumOperations("ryryy"));
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
