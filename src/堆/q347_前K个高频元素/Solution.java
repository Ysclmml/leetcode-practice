package 堆.q347_前K个高频元素;


import java.util.*;

/**
 * Solution
 * create by yscl on 2020/9/16
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<int[]> q = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (q.size() < k) q.add(new int[]{entry.getKey(), entry.getValue()});
            else {
                // 小于栈顶元素舍弃, 大于则更新堆顶元素
                int peekNum = q.peek()[1];
                if (peekNum < entry.getValue()) {
                    q.poll();
                    q.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int i = 0;
        while (!q.isEmpty()) {
            res[i++] = q.poll()[0];
        }
        return res;
    }
}
