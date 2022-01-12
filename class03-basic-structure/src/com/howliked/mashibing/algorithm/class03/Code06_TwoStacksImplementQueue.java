package com.howliked.mashibing.algorithm.class03;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class Code06_TwoStacksImplementQueue {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }

    private static class MyQueue<V> {
        private Stack<V> stackPush;
        private Stack<V> stackPop;

        public MyQueue() {
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void push(V value) {
            stackPush.push(value);
            pushToPop();
        }

        public V poll() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("队列中元素为空!");
            }
            pushToPop();
            return stackPop.pop();
        }

        public V peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("队列中元素为空!");
            }
            pushToPop();
            return stackPop.peek();
        }
    }
}
