package 回溯.q60_第k个排列;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 * create by yscl on 2020/9/16
 */
public class Solution {
    public String getPermutation(int n, int k) {
        // 这里算是取巧, 因为确认k是整数, 所以预先算出n!的阶乘的数的大小
        int[] factor = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
        k--;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) list.add(i);
        while (n-- != 0) {
            int index = k / factor[n];
            sb.append(list.get(index));
            list.remove(index);
            k -= factor[n] * index;
            if (k <= 0) k = 0;
        }
        return sb.toString();
    }
}
