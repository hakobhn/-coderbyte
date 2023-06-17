package com.example.medium;

import java.util.Arrays;
import java.util.Scanner;

class NearestSmallerValues {

    public static int[] NearestSmallerValues(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int num = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] || arr[j] == arr[i]) {
                    num = arr[j];
                    break;
                }
            }
            newArr[i] = num;
        }
        return newArr;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] arr = NearestSmallerValues(inputArray);
        for (int a : arr) System.out.print(a + " ");
    }
}

