package com.example.medium;

import java.util.Scanner;

class Primes {
    public static boolean Primes(int num) {
        boolean isPrime = true;

        for (int i = 2; i < num; i++) {
            if (num >= i && num <= Math.pow(2, 16)) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        //keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(Primes(s.nextInt()));
    }
}