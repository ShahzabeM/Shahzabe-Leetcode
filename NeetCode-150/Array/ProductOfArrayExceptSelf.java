/**
 * Problem: Product of Array Except Self
 * Difficulty: Medium
 * Topic: Arrays
 * Description:
 *   Given an array nums, return an array output such that output[i] is equal to
 *   the product of all the elements of nums except nums[i], without using division.
 *
 * Approach (Brute Force):
 * - For each index, set nums[i] to 1 temporarily.
 * - Multiply all other elements and store in output[i].
 * - Restore nums[i] using a HashMap.
 *
 * Time Complexity: O(n^2)
 */

import java.util.*;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        HashMap<Integer, Integer> PMap = new HashMap<>();

        // Store original values in the HashMap
        for (int i = 0; i < nums.length; i++) {
            PMap.put(i, nums[i]);
        }

        // Iterate through nums and compute product except self
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1; // Temporarily ignore current element
            int multiply = 1;

            for (int j = 0; j < nums.length; j++) {
                multiply *= nums[j];
            }

            output[i] = multiply;
            nums[i] = PMap.get(i); // Restore original value
        }

        return output;
    }
}
