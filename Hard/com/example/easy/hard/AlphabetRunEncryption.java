package com.example.easy.hard;

import java.util.Scanner;

/**
 *
 * Using the Java language, have the function AlphabetRunEncryption(str) read the str parameter being passed
 * which will be an encrypted string and your program should output the original decrypted string. The encryption
 * being used is the following: For every character i in str up to the second to the last character, take the i
 * and i+1 characters and encode them by writing the letters of the alphabet, in order, that range in the same
 * direction between those chosen characters. For example: if the original string were bo then it would be encoded
 * as cdefghijklmn, but if the string were boa then bo is encoded as cdefghijklmn and oa is encoded as nmlkjihgfedcb
 * with the final encrypted string being cdefghijklmnnmlkjihgfedcb. So str may be something like the encrypted string
 * just written, and your program should decrypt it and output the original message. The input string will only
 * contains lowercase characters (a...z). There are also three important rules to this encryption based on specific
 * character sequences.
 *
 *  1) If the original string contains only one letter between two chosen characters, such as the string ac
 *  then this would be encrypted as bR with R standing for what direction in the alphabet to go in determining
 *  the original characters. The encrypted string bR represents ac but the encrypted string bL represents ca
 *  (R = right, L = left).
 *
 *  2) If the original string contains zero letters between two chosen characters, such as the string ab then
 *  this would be encrypted as abS, with S representing the fact that no decryption is needed on the two letters
 *  preceding S. For example, if the original string were aba then the encryption would be abSbaS, but be careful
 *  because decrypting this you get abba, but the actual original string is aba.
 *
 *  3) If the original string contains a repeat of letters, such as the string acc then this would be encrypted
 *  as bRcN, with N representing the fact that no change in characters occurred on the character preceding N.
 *  The input string will never only be composed of repeated characters.
 *
 */
class AlphabetRunEncryption {

    static char SAG = 'R';
    static char SOL = 'L';
    static char IKIZ = 'S';
    static char YOK = 'N';
    static String HEPSI = "RLSN";

    public static String StringChallenge(String str) {
        // code goes here

        StringBuilder result = new StringBuilder("");
        char[] c = str.toCharArray();

        for (int i = c.length - 1; i >= 0; i--) {
            if (i == 0) {
                continue;
            }

            String parca = yeniParca(str, i);
            String sifre = kod(parca);

            if (i != c.length - 1 && result.charAt(0) == sifre.charAt(sifre.length() - 1)) {
                result = result.insert(0, sifre.substring(0, sifre.length() - 1));

            } else {

                result = result.insert(0, sifre);

            }
            i -= parca.length() - 1;

        }

        return result.toString();
    }


    public static String yeniParca(String str, int s) {

        StringBuilder parca = new StringBuilder("");
        boolean artan = str.charAt(s) < str.charAt(s - 1);

        for (int i = s; i >= 0; i--) {

            char c = str.charAt(i);

            if (HEPSI.indexOf(c) != -1 && parca.length() == 0) {
                if (c == SAG || c == SOL || c == YOK) {
                    return str.substring(s - 1, s + 1);
                } else if (c == IKIZ) {
                    return str.substring(s - 2, s + 1);
                }
            }

            if (i == s) {
                parca = parca.append(c);
                continue;
            }

            char prevC = str.charAt(i + 1);
            if (artan && c == (prevC + 1)) {
                parca = parca.insert(0, c);

            } else if (!artan && c == (prevC - 1)) {
                parca = parca.insert(0, c);

            } else {
                break;
            }
        }
        return parca.toString();

    }

    public static String kod(String parca) {

        if (parca.indexOf(SAG) != -1) {
            char c = parca.charAt(0);
            return String.valueOf((char) (c - 1)) + String.valueOf((char) (c + 1));
        } else if (parca.indexOf(SOL) != -1) {
            char c = parca.charAt(0);
            return String.valueOf((char) (c + 1)) + String.valueOf((char) (c - 1));
        } else if (parca.indexOf(IKIZ) != -1) {
            return parca.substring(0, 2);
        } else if (parca.indexOf(YOK) != -1) {
            char c = parca.charAt(0);
            return String.valueOf(c) + String.valueOf(c);

        }


        char bas = parca.charAt(0);
        char son = parca.charAt(parca.length() - 1);

        if (bas > son) {
            return String.valueOf((char) (bas + 1)) + String.valueOf((char) (son - 1));

        }

        return String.valueOf((char) (bas - 1)) + String.valueOf((char) (son + 1));

    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.println(StringChallenge(s.nextLine()));
    }

}