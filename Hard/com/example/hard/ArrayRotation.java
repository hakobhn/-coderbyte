package com.example.hard;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Using the Java language, have the function ArrayRotation(arr)
 * take the arr parameter being passed which will be an array of
 * non-negative integers and circularly rotate the array starting
 * from the Nth element where N is equal to the first integer in
 * the array. For example: if arr is [2, 3, 4, 1, 6, 10] then your
 * program should rotate the array starting from the 2nd position
 * because the first element in the array is 2. The final array will
 * therefore be [4, 1, 6, 10, 2, 3], and your program should return
 * the new array as a string, so for this example your program would
 * return 4161023. The first element in the array will always be an
 * integer greater than or equal to 0 and less than the size of the array.
 */
public class ArrayRotation {

    public static String rotate(int[] numbers) {

        int steps = numbers[0];

        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int index = i%(numbers.length);
            result[i] = numbers[(i+steps)%numbers.length];
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println(rotate(inputArray));
    }

}
