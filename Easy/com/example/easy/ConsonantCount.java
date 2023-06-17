package com.example.easy;

import java.util.Scanner;

/***************************************************************************************
 *                                                                                      *
 *                  CODERBYTE BEGINNER CHALLENGE                                        *
 *                                                                                      *
 *  Vowel Count                                                                         *
 *  Using the Java language, have the function VowelCount(str) take the str             *
 *  string parameter being passed and return the number of vowels the string contains   *
 *  (ie. "All cows eat grass" would return 5). Do not count y as a vowel for this       *
 *  challenge.                                                                          *
 *                                                                                      *
 *  SOLUTION                                                                            *
 *  I will be using two for loops that will be nested. I will be searching through all  *
 *  entries in my vowel array in the outer loop and searching through each letter       *
 *  in the string in the inner loop. I will be comparing each vowel to every letter     *
 *  in the string. If it matches then I will be incrementing by total by 1.
 *
 **/
class ConsonantCount {

    public static int ConsonantCount(String str) {
        int result = 0;
        String vowels = "aeiuoAEIUO";
        for (int i = 0; i < str.length(); i++) {
            if ( vowels.contains(""+str.charAt(i)) ) {
                result = result + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(ConsonantCount(s.nextLine()));
    }
}

