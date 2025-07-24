/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a map to count the frequency of each number
        Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();

        // Iterate through nums array to count the frequency of each element
        for (int n : nums) {
            // Add frequency of each element to the map
            frequencies.put(n, frequencies.getOrDefault(n, 0) + 1);
        }

        // Create a Min-Heap (PriorityQueue) to keep track of top k elements
        // The heap will store numbers, but they will be ordered by their frequency
        // We keep the heap size <= k so that we only store the k most frequent elements
        Queue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> frequencies.get(a) - frequencies.get(b));

        // Iterate through map and add each unique number into the heap
        for (int f : frequencies.keySet()) {
            minHeap.add(f);

            // If the heap grows larger than k, remove the least frequent element
            if (minHeap.size() > k)
                minHeap.poll();
        }

        // Build the answer array from the heap
        // The heap now contains the k most frequent elements
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll(); // Poll returns the element with the smallest frequency
        }

        return ans; // Return the top k frequent elements
    }
}
// @lc code=end
