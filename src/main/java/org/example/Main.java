package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input two strings to test whether they are anagrams. Press enter to see th result");
        while (scan.hasNext()) {
            AnagramChecker.isAnagram(scan.next(), scan.next());
            System.out.println("Current anagrams seen " + AnagramChecker.getProcessedAnagrams());
        }
    }
}