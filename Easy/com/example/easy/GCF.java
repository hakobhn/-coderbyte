package com.example.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * CODERBYTE SOLUTION: DIVISION (GREATEST COMMON FACTOR)
 *
 * Problem: Have the function Division(num1,num2) take both parameters being
 * passed and return the Greatest Common Factor. That is, return the greatest
 * number that evenly goes into both numbers with no remainder. For example:
 * 12 and 16 both are divisible by 1, 2, and 4 so the output should be 4.
 * The range for both parameters will be from 1 to 10^3.
 */
class GCF {

    public static int GCF(int[] arr) {
        // code goes here
        int sayac = 1, gfc = 0;


        while (sayac <= arr[0]) {

            if (arr[0] % sayac == 0 && arr[1] % sayac == 0) gfc = sayac;

            sayac++;
        }

        return gfc == 0 ? 1 : gfc;

    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println(GCF(inputArray));
    }

}
