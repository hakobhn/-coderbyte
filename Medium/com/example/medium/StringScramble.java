package com.example.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * #  Using the Java language, have the function StringScramble(str1,str2) take both parameters being passed and return
 * # the string true if a portion of str1 characters can be rearranged to match str2, otherwise return the string false.
 * # For example: if str1 is "rkqodlw" and str2 is "world" the output should return true. Punctuation and symbols will
 * # not be entered with the parameters.
 *
 */
public class StringScramble {

    private static String StringScramble(String[] strArr) {

        String str = strArr[0].trim();
        String target = strArr[1].trim();

        for (char c : target.toCharArray()) {
            int index = str.indexOf(c);
            if (index < 0) {
                return "false";
            }
            str = str.substring(0, index) + str.substring(index + 1);
        }

        return "true";
    }


    /**
     *
     * rkqodlw, world
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(StringScramble(s.nextLine().split(",")));
    }
}
