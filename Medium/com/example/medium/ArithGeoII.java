package com.example.medium;

import java.util.Arrays;
import java.util.Scanner;


/****************************************************************************************
 *                                                                                      *
 *                  CODERBYTE BEGINNER CHALLENGE                                        *
 *                                                                                      *
 *  Arith Geo                                                                           *
 *  Using the JavaScript language, have the function ArithGeo(arr) take the array of    *
 *  numbers stored in arr and return the string "Arithmetic" if the sequence follows    *
 *  an arithmetic pattern or return "Geometric" if it follows a geometric pattern. If   *
 *  the sequence doesn't follow either pattern return -1. An arithmetic sequence is     *
 *  one where the difference between each of the numbers is consistent, where as in a   *
 *  geometric sequence, each term after the first is multiplied by some constant or     *
 *  common ratio. Arithmetic example: [2, 4, 6, 8] and Geometric                        *
 *  example: [2, 6, 18, 54]. Negative numbers may be entered as parameters, 0 will not  *
 *  be entered, and no array will contain all the same elements.                        *
 *                                                                                      *
 *  SOLUTION                                                                            *
 *  To check for arithmetic pattern, start by getting the difference between the first  *
 *  two number. Then loop thru array starting in position 2 and subtract the previous   *
 *  number. If the difference is equal to the initial difference then you have an       *
 *  arithmetic pattern so return arithmetic. Next repeat by getting initial difference  *
 *  by dividing the first and second numbers. Loop through array starting in position   *
 *  2 and compare the current number divided by previous number. If difference is       *
 *  equal to the initial number then you have a geometric pattern. Else return -1.      *
 *  */

class ArithGeoII {

    public static String ArithGeoII(int[] arr) {
        double ratio = arr[1] / arr[0];
        int difference = arr[1] - arr[0];
        String arithgeo = "";
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == difference) {
                if (!arithgeo.equals("Geometric")) {
                    arithgeo = "Arithmetic";
                } else {
                    return "-1";
                }
            } else {
                if (arithgeo.equals("Arithmetic")) {
                    return "-1";
                }
            }
            if (arr[i + 1] / arr[i] == ratio) {
                if (!arithgeo.equals("Arithmetic")) {
                    arithgeo = "Geometric";
                } else {
                    return "-1";
                }
            } else {
                if (arithgeo.equals("Geometric")) {
                    return "-1";
                }
            }
            if (arithgeo.equals("")) {
                return "-1";
            }
        }
        // code goes here
        return arithgeo;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println(ArithGeoII(inputArray));
    }

}
