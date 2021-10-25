package com.howliked.mashibing.algorithm.class06;

/**
 * 大根堆:根结点（亦称为堆顶）的关键字是堆里所有结点关键字中最大者，属于二叉堆的两种形式之一。
 */
public class Code02_Heap {

    public static void main(String[] args) {
        MyMaxHeap maxHeap = new MyMaxHeap(5);
        maxHeap.push(1);
        maxHeap.push(3);
        System.out.println(maxHeap.pop());
        maxHeap.push(2);
        System.out.println(maxHeap.pop());
    }

    private static class MyMaxHeap {
        private int[] heap;
        private int heapSize;
        private int limit;

        public MyMaxHeap(int limit) {
            this.heap = new int[limit];
            this.heapSize = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full!");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        private void heapify(int[] heap, int index, int heapSize) {
            //
            int left = index * 2 + 1;
            while (left < heapSize) {
                //判断是否有右节点,右节点比左节点大
                int largest = left + 1 > heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
                //最大的这个值与index比较
                largest = heap[largest] > heap[index] ? largest : index;
                if (largest == index) return;
                swap(heap, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void heapInsert(int[] heap, int index) {
            int parent = (index - 1) / 2;
            while (heap[index] > heap[parent]) {
                swap(heap, index, parent);
                index = parent;
            }
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
