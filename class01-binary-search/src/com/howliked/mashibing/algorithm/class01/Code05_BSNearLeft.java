package com.howliked.mashibing.algorithm.class01;

/**
 * 在arr上，找满足>=value的最左位置
 */
public class Code05_BSNearLeft {
    public static void main(String[] args) {
        int[] sortedArr = new int[]{1, 3, 5, 7, 9};
        System.out.println(nearestIndex(sortedArr, 2));
    }

    //
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int middle = L + ((R - L) >> 1);
            if (arr[middle] >= value) {
                index = middle;
                R = middle - 1;
            } else {
                L = middle + 1;
            }
        }
        return index;
    }
}
