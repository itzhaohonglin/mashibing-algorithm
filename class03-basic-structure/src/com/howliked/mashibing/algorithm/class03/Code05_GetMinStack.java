package com.howliked.mashibing.algorithm.class03;

import java.util.Stack;

/**
 * 获取栈中最小的值
 */
public class Code05_GetMinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
    }

    private static class MinStack {
        private Stack<Integer> stackData;
        private Stack<Integer> minStack;

        public MinStack() {
            stackData = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(Integer value) {
            if (minStack.isEmpty()) {
                minStack.push(value);
            } else if (value < this.getMin()) {
                minStack.push(value);
            }
            stackData.push(value);
        }

        public Integer pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("栈中元素为空");
            }
            Integer value = stackData.pop();
            if (value == this.getMin()) {
                minStack.pop();
            }
            return value;
        }

        public Integer getMin() {
            return minStack.peek();
        }

    }

}
