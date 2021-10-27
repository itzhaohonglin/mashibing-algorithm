package com.howliked.mashibing.algorithm.class08;

public class Code03_CountSort {
    public static void main(String[] args) {
        int[] array = new int[]{23, 23, 24, 20, 25, 18, 46, 36, 34, 35};
        countSort(array);
        printArray(array);
    }

    // only for 0~200 value
    public static void countSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            
            while (bucket[i]-- > 0) {
                arr[j++] = i;
            }
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
