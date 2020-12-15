package 数组.q454_四数相加2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        int len = A.length;

        if (len == 0) return 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        Map<Integer, Integer> map = new HashMap<>();
        // 先统计第一个数的个数
        for (int i = 0; i < D.length; i++) {
            map.put(D[i], map.getOrDefault(D[i], 0) + 1);
        }
        int countA = 1;
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && A[i] == A[i + 1]) {
                countA += 1;
                continue;
            }
            int one = A[i];
            if (-one > B[len - 1] + C[len - 1] + D[len - 1] || -one < B[0] + C[0] + D[0]) {
                countA = 1;
                continue; // 剪枝处理
            }
            int countB = 1;
            for (int j = 0; j < len; j++) {
                if (j < len - 1 && B[j] == B[j + 1]) {
                    countB += 1;
                    continue;
                }
                int two = B[j] + one;
                if (-two > C[len - 1] + D[len - 1] || -two < C[0] + D[0]) continue;
                int countC = 1;
                for (int k = 0; k < len; k++) {
                    if (k < len - 1 && C[k] == C[k + 1]) {
                        countC += 1;
                        continue;
                    }
                    int three = C[k] + two;
                    if (map.containsKey(-three)) {
                        int countD = map.getOrDefault(-three, 0);
                        count += countD * countC * countB * countA;
                    }
                }
            }
            countA = 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.fourSumCount(new int[]{1}, new int[]{-1}, new int[]{0}, new int[]{1}));
        System.out.println(s.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }

    @Test
    public void testSolution() {
        Solution2 s = new Solution2();
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
