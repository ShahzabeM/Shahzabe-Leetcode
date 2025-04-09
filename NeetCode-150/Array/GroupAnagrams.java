/**
 * Problem: Group Anagrams
 * Difficulty: Medium
 * Topic: Strings, HashMap, Sorting
 * Description:
 *   Group words that are anagrams of each other.
 *   Anagrams are words that have the same letters in a different order.
 *
 * Approach:
 * - Sort each word to get a standardized key.
 * - Use a HashMap where:
 *     - key = sorted version of the word
 *     - value = list of words that match that key (i.e., anagrams)
 * - At the end, return all values in the map.
 */

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to group words by their sorted version
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String word : strs) {
            // Sort the characters of the word
            char[] sortedChars = word.toCharArray();
            Arrays.sort(sortedChars);
            String sortedWord = new String(sortedChars);

            // Add word to the corresponding list in the map
            anagramMap.putIfAbsent(sortedWord, new ArrayList<>());
            anagramMap.get(sortedWord).add(word);
        }

        // Return all grouped anagrams
        return new ArrayList<>(anagramMap.values());
    }
}
