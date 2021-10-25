package com.howliked.mashibing.algorithm.class06;

public class Code03_HeapSort {

    // 堆排序额外空间复杂度O(1)
    public static void heapSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        for (int j = arr.length - 1; j > 0; j--) {
            heapify(arr, j, arr.length);
        }
        int size = arr.length;
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }

    }

    private static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : left;
            if (largest == index) {
                return;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
