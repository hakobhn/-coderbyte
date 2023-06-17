package com.example.medium;

import java.util.Scanner;

class PrimeTime {


    public static boolean PrimeTime(int num) {
        //code goes here
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i < num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(PrimeTime(s.nextInt()));
    }
}
