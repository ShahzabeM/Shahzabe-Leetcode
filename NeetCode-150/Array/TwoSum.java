/**
 * Problem: Two Sum
 * Difficulty: Easy
 * Topic: Arrays, HashMap
 * Description:
 *   Given an array of integers and a target integer, return the indices
 *   of the two numbers that add up to the target.
 *
 * Approach:
 * - Use a HashMap to store each number and its index as we iterate.
 * - For each element, check if (target - current number) exists in the map.
 * - If it does, return the pair of indices.
 */

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store number → index
        HashMap<Integer, Integer> TS = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i]; // the value needed to reach the target

            // If the map already contains the complement, return the indices
            if (TS.containsKey(rem)) {
                return new int[]{TS.get(rem), i};
            }

            // Store the current number with its index
            TS.put(nums[i], i);
        }

        // If no solution is found (problem guarantees one), return empty
        return new int[]{};
    }
}
