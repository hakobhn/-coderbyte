package com.example.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *	Using the Java language, have the function AlphabetSoup(str) take the str string parameter being passed
 *	and return the string with the letters in alphabetical order (ie. hello becomes ehllo).
 *
 *	Assume numbers and punctuation symbols will not be included in the string.
 */
class AlphabetSoup {

    public static String AlphabetSoup(String str) {
        // code goes here
        String newstr = "";
//        String[] kelime = str.split("");
//        Arrays.sort(kelime);
//        for (String k : kelime) {
//            newstr += k;
//        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        newstr = new String(chars);

        return newstr;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(AlphabetSoup(s.nextLine()));
    }

}
