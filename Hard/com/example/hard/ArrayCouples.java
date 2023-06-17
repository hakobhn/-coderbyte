package com.example.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * have the function ArrayCouples(arr) take the arr parameter being passed which will be an array of an
 * even number of positive integers, and determine if each pair of integers, [k, k+1], [k+2, k+3], etc.
 * in the array has a corresponding reversed pair somewhere else in the array. For example: if arr
 * is [4, 5, 1, 4, 5, 4, 4, 1] then your program should output the string yes because the first pair 4, 5
 * has the reversed pair 5, 4 in the array, and the next pair, 1, 4 has the reversed pair 4, 1 in the array
 * as well. But if the array doesn't contain all pairs with their reversed pairs, then your program should
 * output a string of the integer pairs that are incorrect, in the order that they appear in the array.
 * For example: if arr is [6, 2, 2, 6, 5, 14, 14, 1] then your program should output the string 5,14,14,1
 * with only a comma separating the integers.
 */
class ArrayCouples {

    public static String ArrayCouples(int[] arr) {
        ArrayList<Integer> pairs = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> allPairs = new ArrayList<ArrayList<Integer>>();
        int j = 0;
        for (int i = 0; i < arr.length - 1; i += 2) {
            j = i + 1;
            pairs.add(arr[i]);
            pairs.add(arr[j]);
            allPairs.add(pairs);
            pairs = new ArrayList<Integer>();
        }
        ArrayList<Integer> unPairs = findMatch(allPairs);
        if (unPairs.isEmpty()) {
            return "yes";
        } else {
            String listString = unPairs.stream().map(Object::toString)
                    .collect(Collectors.joining(","));
            return listString;
        }
    }

    public static ArrayList<Integer> reversed(ArrayList<Integer> list) {
        ArrayList<Integer> rev = new ArrayList<Integer>();
        for (int i = list.size() - 1; i >= 0; i--) {
            rev.add(list.get(i));
        }
        return rev;
    }

    public static ArrayList<Integer> findMatch(ArrayList<ArrayList<Integer>> allPairs) {
        ArrayList<Integer> unPairs = new ArrayList<Integer>();
        ArrayList<Integer> reversed = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> checkPairs = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> copyPairs = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < allPairs.size(); i++) {
            copyPairs.add(allPairs.get(i));
        }
        for (ArrayList<Integer> k : allPairs) {
            copyPairs.remove(k);
            reversed = reversed(k);
            if (!(copyPairs.contains(reversed))) {
                if (!(checkPairs.contains(reversed))) {
                    unPairs.addAll(k);
                }
            } else {
                checkPairs.add(k);
            }
        }
        return unPairs;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
//        System.out.println(ArrayCouples(new int[]{5, 4, 6, 7, 7, 6, 4, 5}));
        String input = s.nextLine();
        int[] inputArray = Arrays.stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        System.out.println(ArrayCouples(inputArray));
    }
}