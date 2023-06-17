package com.example.hard;

import java.util.Arrays;
import java.util.Scanner;

class NimWinner {

    public static int NimWinner(int[] arr) {

        int mResult = 0, x = 0;

        for (int i = 0; i < arr.length; i++) {
            x ^= arr[i];
            mResult = x > 0 ? 1 : 2;
        }
        return mResult;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.print(NimWinner(inputArray));
    }
}