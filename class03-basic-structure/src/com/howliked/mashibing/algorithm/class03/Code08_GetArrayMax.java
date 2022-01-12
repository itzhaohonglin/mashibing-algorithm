package com.howliked.mashibing.algorithm.class03;

/**
 * 求arr中的最大值
 */
public class Code08_GetArrayMax {

    public static void main(String[] args) {
        System.out.println(getMax(new int[]{1, 4, 3, 2, 5}));
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]范围上求最大值  L ... R   N
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int left = process(arr, L, mid);
        int right = process(arr, mid + 1, R);

        return Math.max(left, right);
    }

}
