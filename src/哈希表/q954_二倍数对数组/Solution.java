package 哈希表.q954_二倍数对数组;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Solution
 * create by yscl on 2020/9/8
 */
public class Solution {
    public boolean canReorderDoubled(int[] A) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        // 每个键及其个数
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 0) continue;
            if (key < 0) {
                if (key % 2 != 0) return false;
                if (!map.containsKey(key / 2)) {
                    return false;
                } else {
                    int c = map.get(key / 2);
                    if (c < value) {
                        return false;
                    } else {
                        map.put(key / 2, c - value);
                    }
                }
            } else if(key == 0) {
                if (value % 2 != 0) return false;
            } else {
                if (!map.containsKey(2 * key)) {
                    return false;
                } else {
                    int c = map.get(2 * key);
                    if (c < value) {
                        return false;
                    } else {
                        map.put(2 * key, c - value);
                    }
                }
            }
        }
        return true;
    }
}
