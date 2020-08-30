package com.possible;

import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        int[] A = { 3, 4, };
        int[] B = { 1, 2, };
        int[] mergeArray  = encodeArray(A, B);
        System.out.println(decodeArray(mergeArray, new int[]{ 3, 4}));
    }

    public static int encodeInteger(int x, int n) {
        n = n << (1 << (1 << (1 << 1)));
        x = x | n;
        return x;
    }

    public static int[] encodeArray(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            A[i] = encodeInteger(A[i], B[i]);
        }
        return A;
    }

    public static String decodeArray(int[] encodedArray, int[] A) {
        int len = encodedArray.length;
        int[] B = new int[len];
        int key = 1 << (1 << (1 << 1));
        for (int i = 0; i < len; i++) {
            B[i] = (encodedArray[i] ^ A[i]) >> key;
        }
        return Arrays.toString(B);
    }
}
