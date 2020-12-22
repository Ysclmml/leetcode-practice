package 数据结构.qOffer_59队列的最大值;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)
 * create by yscl on 2020/9/22
 */
public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        // 保存数
        queue = new LinkedList<>();
        // 保存最大值数据, 单调递减.
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        // 维护最大值数据队列
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int val = queue.poll();
        if (val >= deque.peekFirst()) {
            deque.pollFirst();
        }
        return val;
    }
}
