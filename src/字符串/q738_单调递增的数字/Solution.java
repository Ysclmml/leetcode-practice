package 字符串.q738_单调递增的数字;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {

    public int monotoneIncreasingDigits(int N) {
        // 找到第一处逆序的位置
        String s = Integer.toString(N);
        int len = s.length();
        if (len == 1) return N;
        StringBuilder sb = new StringBuilder(s);
        int start = 1;
        while (start < len) {
            if (sb.charAt(start - 1) <= sb.charAt(start)) {
                start++;
            } else {
                int stop = start;
                start--;
                while (start >= 0) {
                    char cur = sb.charAt(start);
                    // prev = sb.charAt(start - 2);
                    if (cur == '0') {
                        sb.setCharAt(start, '9');
                        start--;
                    } else {
                        char c = (char) (cur - 1);
                        sb.setCharAt(start, c);
                        sb.setCharAt(start + 1, '9'); // 前面减1, 后面可以直接置为9
                        start--;
                        if (start >= 0 && sb.charAt(start) <= c) {
                            break;
                        }
                    }
                }
                for (int i = stop; i < len; i++) {
                    sb.setCharAt(i, '9');
                }
                break;
            }
        }
        // 将对应逆序的位置依次减1处理
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(28888));
        System.out.println(new Solution().monotoneIncreasingDigits(28080));
        System.out.println(new Solution().monotoneIncreasingDigits(332));
        System.out.println(new Solution().monotoneIncreasingDigits(1332));
        System.out.println(new Solution().monotoneIncreasingDigits(125550879));
        System.out.println(new Solution().monotoneIncreasingDigits(155550879));
        System.out.println(new Solution().monotoneIncreasingDigits(555550879));
        System.out.println(new Solution().monotoneIncreasingDigits(125879));
        System.out.println(new Solution().monotoneIncreasingDigits(10));
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
