package com.possible;

import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        int[] A = new int[] { 1, 2, 3 };
        int[] B = new int[] { 4, 5, 6 };
        int arrSize = 3;
        int[] mergeArray  = encodeArray(A, B, arrSize);
        System.out.println(decodeArrayB(mergeArray, new int[] { 1, 2, 3 }));
    }


    public static int encodeInteger(int x, int n) {
        n = n << (1 << (1 << (1 << 1)));
        x = x | n;
        return x;
    }

    public static int[] encodeArray(int[] A, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[i] = encodeInteger(A[i], B[i]);
        }
        return A;
    }

    public static String decodeArrayB(int[] encodedArray, int[] A) {
        int len = encodedArray.length;
        int[] B = new int[len];
        int key = 1 << (1 << (1 << 1));
        for (int i = 0; i < len; i++) {
            int c = (encodedArray[i] ^ A[i]) >> key;
            B[i] = c;
        }
        return Arrays.toString(B);
    }
}
