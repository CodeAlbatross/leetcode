package com.company.normal;

import java.util.Stack;

/**
 * 可以找到最小值的栈
 */
class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()){
            minStack.push(x);
        }else {
            if (x < minStack.peek()){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int x = stack.peek();
        stack.pop();
        if (x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
