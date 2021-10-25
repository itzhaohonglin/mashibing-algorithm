package com.howliked.mashibing.algorithm.class01;

/**
 * 选择排序:选择数组中最小的值,依次替换
 */
public class Code01_SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 9, 2, 3, 8, 7};
        selectionSort(array);
        printArray(array);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[min] <= arr[j] ? min : j;
            }
            swap(arr, i, min);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

}
