package 哈希表.q954_二倍数对数组;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 写法2, 原来的写法太麻烦了, 思路也比较复杂, 可以直接使用绝对值进行比较
 * create by yscl on 2020/9/8
 */
public class Solution2 {
    public boolean canReorderDoubled(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 获取每个元素的数据
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; i++)
            B[i] = A[i];
        // 必须使用Integer来进行比较, 使用int进行比较会发生错误
        Arrays.sort(B, Comparator.comparingInt(Math::abs));
        for (int x : B) {
            if (map.get(x) == 0) continue;
            // 说明没有与之配对的
            if (map.getOrDefault(2 * x, 0) <= 0) return false;
            map.put(x, map.get(x) - 1);
            map.put(2 * x, map.get(2 * x) - 1);
        }
        return true;
    }
}
