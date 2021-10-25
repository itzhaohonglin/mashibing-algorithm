package com.howliked.mashibing.algorithm.class04;

public class Code01_MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 2, 8, 3, 5, 6};
        mergeSort(array);
        printArray(array);
    }

    // 递归方法实现
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int middle = L + ((R - L) >> 1);
        process(arr, L, middle);
        process(arr, middle + 1, R);
        merge(arr, L, middle, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
