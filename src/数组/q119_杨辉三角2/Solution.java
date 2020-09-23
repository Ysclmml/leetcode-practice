package 数组.q119_杨辉三角2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) res.add(1);
        if (rowIndex < 1) return res;
        for (int i = 0; i <= rowIndex; i++) {
            int first = res.get(0);
            int second = res.get(1);
            for (int j = 1; j < i; j++) {
                int tmp = first + second;
                first = second;
                second = res.get(j + 1);
                res.set(j, tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(0));
        System.out.println(new Solution().getRow(1));
        System.out.println(new Solution().getRow(2));
        System.out.println(new Solution().getRow(3));
        System.out.println(new Solution().getRow(4));
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals("", "");
    }
}
