package com.howliked.mashibing.algorithm.class05;

public class Code02_PartitionAndQuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 1, 3, 9, 5};
        quickSort1(array);
        printArray(array);
    }

    private static void quickSort1(int[] array) {
        if (array.length == 0) {
            return;
        }
        process1(array, 0, array.length - 1);
    }

    private static void process1(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(array, L, R);
        process1(array, L, M - 1);
        process1(array, M + 1, R);
    }

    private static int partition(int[] array, int L, int R) {
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (array[index] < array[R]) {
                swap(array, index, ++lessEqual);
            }
            index++;
        }
        swap(array, ++lessEqual, R);
        return lessEqual;
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
