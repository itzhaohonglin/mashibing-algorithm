package com.howliked.mashibing.algorithm.class01;

public class Code04_BSExist {
    public static void main(String[] args) {
        int[] sortedArr = new int[]{1, 3, 5, 7, 9};
        System.out.println(exist(sortedArr, 2));
    }

    public static boolean exist(int[] sortedArr, int num) {
        int size = sortedArr.length;
        int l = 0;
        int r = size - 1;
        while (l < r) {
            int middle = l+((r-l)>>1);
            if (sortedArr[middle] == num) {
                return true;
            } else if (sortedArr[middle] > num) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return sortedArr[l] == num;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
