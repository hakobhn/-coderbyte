package com.example.easy;

import java.util.Scanner;

class FirstReverse {

    public static String FirstReverse(String str) {
        // code goes here
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(FirstReverse(s.nextLine()));
    }
}