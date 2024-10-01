package org.example;

import java.util.*;

public class AnagramChecker {
    private static HashMap<String, LinkedList<String>> keysAnagrams = new HashMap<>();
    private static String sortedChars(String s){

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     *
     * @param a
     * @param b
     * @return true , if paramters a and b are anagrams of each other. Otherwise, false
     */
    public static boolean isAnagram(String a , String b){
        if( a == null || b == null) {
            return false;
        }
        a = a.strip();
        b = b.strip();
        if(!a.isEmpty() && !b.isEmpty() && a.length()==b.length()) {
            String key = sortedChars(a);
            if(key.equalsIgnoreCase(sortedChars(b))){
                updateAnagramsOf(a, b);
                return true;
            }

        }
        return false;
    }

    /**
     * caches b to the list of anagrams of key , if b and key are anagrams
     * @param b
     * @param key the
     */
    private static void updateAnagramsOf( String key, String b) {
        List<String > anagrams = keysAnagrams.computeIfAbsent(key, k -> new LinkedList<>());
        anagrams.remove(b);
        anagrams.add(b);
    }

    /**
     *
     * @param key
     * @return all of anagrams of key
     */
    public static List<String> anagramsOf(String key){
        return keysAnagrams.get(key);
    }
    public static void clearAnagramsMap(){
        keysAnagrams.clear();
    }

    public static Map<String, LinkedList<String>> getProcessedAnagrams(){
        return keysAnagrams;
    }
}
