
/**
 * Problem: Top K Frequent Elements
 * Difficulty: Medium
 * Topic: HashMap, Heap (PriorityQueue)
 * Description:
 *   Return the k most frequent elements from the input array.
 *
 * Approach:
 * - Count the frequency of each number using a HashMap.
 * - Use a min-heap (priority queue) to keep only the top k frequent elements.
 * - At the end, extract the keys from the heap to get the result.
 */

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency count using HashMap
        HashMap<Integer, Integer> KMap = new HashMap<>();
        for (int num : nums) {
            KMap.put(num, KMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a min-heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()  // sort by value (frequency)
        );

        // Step 3: Add entries to the heap, keep size <= k
        for (Map.Entry<Integer, Integer> entry : KMap.entrySet()) {
            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll(); // Remove least frequent
            }
        }

        // Step 4: Extract top k elements from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
