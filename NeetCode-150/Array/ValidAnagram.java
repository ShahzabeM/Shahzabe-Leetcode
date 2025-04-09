/**
 * Problem: Valid Anagram
 * Difficulty: Easy
 * Topic: Strings, HashMap
 * Description:
 *   Determine if two strings are anagrams of each other.
 *   Two strings are anagrams if they contain the same characters
 *   with the same frequencies, in any order.
 *
 * Approach:
 * - Create two HashMaps to count character frequencies for both strings.
 * - Compare both maps; if equal, they are anagrams.
 */

import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        // Count occurrences in string s
        for (char c : s.toCharArray()) {
            countS.put(c, countS.getOrDefault(c, 0) + 1);
        }

        // Count occurrences in string t
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        return countS.equals(countT);
    }
}
