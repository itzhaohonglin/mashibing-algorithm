package com.howliked.mashibing.algorithm.class01;

/**
 * 插入排序
 */
public class Code03_InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 9, 2, 3, 8, 7};
        insertionSort(array);
        printArray(array);
    }

    /**
     * 0~i有序
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //i之前的数,进行比较替换,做到0~i有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    // i和j是一个位置的话，会出错
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
