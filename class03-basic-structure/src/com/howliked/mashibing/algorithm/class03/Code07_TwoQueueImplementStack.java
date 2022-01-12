package com.howliked.mashibing.algorithm.class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 */
public class Code07_TwoQueueImplementStack {

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    private static class MyStack<V> {
        private Queue<V> queue;
        private Queue<V> help;

        public MyStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(V value) {
            queue.add(value);
        }

        public V pop() {
            while (queue.size() != 1) {
                help.offer(queue.poll());
            }
            V result = queue.poll();
            Queue<V> temp = help;
            help = queue;
            queue = temp;
            return result;
        }
    }
}
