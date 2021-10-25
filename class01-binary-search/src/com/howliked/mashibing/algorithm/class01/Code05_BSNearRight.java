package com.howliked.mashibing.algorithm.class01;

public class Code05_BSNearRight {
    public static void main(String[] args) {
        int[] sortedArr = new int[]{1, 3, 5, 7, 9};
        System.out.println(nearestIndex(sortedArr, 4));
    }

    // 在arr上，找满足<=value的最右位置
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int index = -1;
        int R = arr.length - 1;
        while (L <= R) {
            int middle = L + ((R - L) >> 1);
            if (arr[middle] <= value) {
                index = middle;
                L = middle + 1;
            } else {
                R = middle - 1;
            }
        }
        return index;
    }
}
