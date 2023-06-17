package com.example.medium;

import java.util.Scanner;


/**
 *
 * Using the Java language, have the function CaesarCipher(str,num)
 * take the str parameter and perform a Caesar Cipher shift on it using the num
 * parameter as the shifting number. A Caesar Cipher works by shifting each letter
 * in the string N places down in the alphabet (in this case N will be num).
 * Punctuation, spaces, and capitalization should remain intact.
 * For example if the string is "Caesar Cipher" and num is 2 the output should be "Ecguct Ekrjgt"
 *
 */
class CaesarCipher {

    public static String CaesarCipher(String str, int num) {
        // code goes here
        int code, newCode;
        String result = "", newChar;

        for (int i = 0; i < str.length(); i++) {
            code = (int) str.charAt(i);
            newCode = code + num;

            if (code >= 65 && code <= 90) {
                if (newCode > 90)
                    newCode = 64 + (newCode - 90);
            } else if (code >= 97 && code <= 122) {
                if (newCode > 122)
                    newCode = 96 + (newCode - 122);
            } else {
                newCode = code;
            }

            newChar = String.valueOf((char) newCode);
            result += newChar;
        }
        return result;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(CaesarCipher(s.nextLine(), s.nextInt()));
    }
}