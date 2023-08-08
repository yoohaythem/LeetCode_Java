package com.LeetCode.Hot100._055_最小栈_155;

import java.util.Deque;
import java.util.LinkedList;

//20221109
class MySolution {

}

// 1. 使用辅助栈
class MinStack_1 {

    Deque<Integer> stack;
    Deque<Integer> min_stack;


    public MinStack_1() {
        this.stack = new LinkedList<>();
        this.min_stack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        min_stack.push(min_stack.isEmpty() ? val : Math.min(val, min_stack.peek()));
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.isEmpty() ? Integer.MIN_VALUE : stack.peek();
    }

    public int getMin() {
        return min_stack.isEmpty() ? Integer.MIN_VALUE : min_stack.peek();
    }
}


// 2. 不使用辅助栈，只在栈中记录与最小元素的差。差为负数说明发生了一次最小值的变更。
//    但是这里需要考虑取值范围的越界问题，过程中采用Long代替Integer
class MinStack_2 {

    Deque<Long> stack;
    Long min;


    public MinStack_2() {
        this.stack = new LinkedList<>();
        this.min = 0L;
    }

    public void push(int val) {
        Long value = (long) val;
        if (stack.isEmpty()) {
            stack.push(0L);
            min = value;
        } else {
            stack.push(value - min);
        }
        min = Math.min(min, value);
    }

    public void pop() {
        Long diff = stack.pop();
        if (diff < 0L) {
            min -= diff;
        }
    }

    public int top() {
        return stack.isEmpty() ? Integer.MIN_VALUE : (int) (Math.max(stack.peek(), 0) + min);
    }

    public int getMin() {
        return Math.toIntExact(min);
    }
}
