package com.example.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Using the JavaScript language, have the function ArrayAdditionI(arr) take the array *
 * *  of numbers stored in arr and return the string true if any combination of numbers   *
 * *  in the array can be added up to equal the largest number in the array, otherwise    *
 * *  return the string false. For example: if arr contains [4, 6, 23, 10, 1, 3] the      *
 * *  output should return true because 4 + 6 + 10 + 3 = 23. The array will not be empty, *
 * *  will not contain all the same elements, and may contain negative numbers.
 */
public class ArrayAdditionI {

    private static String ArrayAdditionI(int[] arr) {
        if (arr.length<3) {
            return "false";
        }

        List<Integer> list =  Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.sort(Integer::compareTo);

        Integer max = list.get(list.size()-1);
        list.remove(list.size()-1);
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            total = 0;
            for (int j = i; j < list.size(); j++) {
                total += list.get(j);
                if (total == max) {
                    return "true";
                }
            }
        }

        return "false";
    }


    /**
     *
     * 4, 6, 23, 10, 1, 3
     *
     * @param args
     */
    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(ArrayAdditionI(inputArray));
    }
}
