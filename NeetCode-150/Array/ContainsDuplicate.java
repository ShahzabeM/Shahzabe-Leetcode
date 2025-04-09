/**
 * Problem: Contains Duplicate
 * Difficulty: Easy
 * Topic: Arrays, HashSet
 * Description: Check if the input array contains any duplicates.
 * 
 * Approach:
 * - Use a HashSet to store unique elements while traversing the array.
 * - If a number already exists in the HashSet, return true.
 * - If loop completes with no duplicates found, return false.
 */

import java.util.HashSet;

public class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> CD = new HashSet<>();

        for (int num : nums) {
            if (CD.contains(num)) {
                return true;
            }
            CD.add(num);
        }

        return false;
    }
}
