package com.example.easy.hard;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * Kaprekar constant, or 6174, is a constant that arises when we take a 4-digit integer,
 * form the largest and smallest numbers from its digits, and then subtract these two numbers.
 * Continuing with this process of forming and subtracting, we will always arrive at the number 6174.
 *
 * An illustration:
 *
 * Take a 4-digit number like 3215. Rearranging to form the largest and smallest with these digits,
 * we get 5321 and1235. Now, subtract them: 5321-1235 = 4086. Continue with the process of rearranging and subtracting:
 *
 *
 * 8640−0468=8172
 * 8721−1278=7443
 * 7443−3447=3996
 * 9963−3699=6264
 * 6642−2466=4176
 * 7641−1467=6174
 *
 * We stop here since we will only get into a loop and keep getting 6174.
 *
 * Kaprekar's Constant is the number 6174.
 * This number is special because it has the property where for any 4-digit number
 * that has 2 or more unique digits,
 * if you repeatedly apply a certain function it always reaches the number 6174.
 *
 * This certain function is as follows:
 *  - Order the number in ascending form and descending form to create 2 numbers.
 *  - Pad the descending number with zeros until it is 4 digits in length.
 *  - Subtract the ascending number from the descending number.
 *  - Repeat.
 *
 * Given a number n, find the number of times the function needs to be applied to reach
 * Kaprekar's constant. Here's some starter code:
 */
class KaprekarsConstant {

    public static int count = 0;

    public static int KaprekarsConstant(int num) {

        String other = Integer.toString(num);
//        int[] arr = new int[other.length()];
//
//        for (int i = 0; i < other.length(); i++) {
//            arr[i] = other.charAt(i) - '0';
//        }
        char[] arr = other.toCharArray();
        Arrays.sort(arr);

        String low = "";
        for (int i = 0; i < arr.length; i++) {
            low += arr[i];
        }

        String high = new StringBuilder(low).reverse().toString();
        int diff = Integer.parseInt(high) - Integer.parseInt(low);

        if (diff < 1000) {
            diff = Integer.parseInt(diff + "0");
        }
        count++;
        System.out.println("diff: " + diff);
        return diff != 6174 ? KaprekarsConstant(diff) : count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(KaprekarsConstant(s.nextInt()));
    }
}
