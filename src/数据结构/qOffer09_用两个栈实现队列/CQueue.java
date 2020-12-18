package 数据结构.qOffer09_用两个栈实现队列;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * 这个队列需要实现删除头节点和添加尾节点的时间复杂度为1, 并且需要使用两个栈来实现.
 */
class CQueue {

    private Stack<Integer> stack1;  // 用来支持插入操作
    private Stack<Integer> stack2;  // 用来支持删除操作.

    public CQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 思路, 如果stack2为空, 则把stack1所有的元素弹出到stack2种.
        // 如果stack2依然为空, 说明没有元素, 返回-1
        // 弹出stack2的一个元素. 最后均摊的时间复杂度为o(1)
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
