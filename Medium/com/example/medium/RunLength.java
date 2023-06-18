package com.example.medium;

import java.util.Scanner;

/**
 *
 * # Have the function RunLength(str) take the str parameter being passed and return a compressed version of the string
 * # using the Run-length encoding algorithm. This algorithm works by taking the occurrence of each repeating character
 * # and outputting that number along with a single character of the repeating sequence. For example: "wwwggopp" would
 * # return 3w2g1o2p. The string will not contain any numbers, punctuation, or symbols.
 *
 */
class RunLength {

    public static String RunLength(String str) {
        // code goes here
        String repost = "";
        int count = 1;
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            } else {
                repost += count + "" + c;
                c = str.charAt(i);
                count = 1;
            }
        }

        repost += count + "" + c;

        return repost;
    }

    /**
     * wwwggopp
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(RunLength(s.nextLine()));
    }
}
