package com.example.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * For this challenge you will perform a bitwise operation on two binary numbers.
 * have the function BitwiseTwo(strArr) take the array of strings stored in strArr,
 * which will only contain two strings of equal length that represent binary numbers,
 * and return a final binary string that performed the bitwise AND operation on both strings.
 * A bitwise AND operation places a 1 in the new string where there is a 1 in both locations
 * in the binary strings, otherwise it places a 0 in that spot. For example: if strArr is ["10111", "01101"]
 * then your program should return the string "00101"
 */
class BitwiseTwo {

    public static String ArrayChallenge(String[] strArr) {
        String str = "";
        for (int i = 0; i < strArr[0].length(); i++) {
            if (strArr[0].charAt(i) == '1' && strArr[1].charAt(i) == '1') {
                str += "1";
            } else if (strArr[0].charAt(i) == '1' && strArr[1].charAt(i) == '0') {
                str += "0";
            } else if (strArr[0].charAt(i) == '0' && strArr[1].charAt(i) == '0') {
                str += "0";
            } else if (strArr[0].charAt(i) == '0' && strArr[1].charAt(i) == '1') {
                str += "0";
            }
        }
        return str;
    }

    /**
     * 110110,100111
     * 100110
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] inputArray = input.split(",");
        System.out.println(ArrayChallenge(inputArray));
    }

}