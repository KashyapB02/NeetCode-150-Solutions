/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start

import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a Max-heap:
        // PriorityQueue is min-heap by default,
        // so reverse order to get max-heap behavior.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        // Push all stone weights into the heap.
        for (int weight : stones) {
            maxHeap.add(weight);
        }

        // Keep smashing the two heaviest stones until 0 or 1 stone remains.
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // second heaviest

            // If they are unequal, the difference (new stone) goes back into the heap.
            if (y != x)
                maxHeap.add(y - x);

            // If equal, both are destroyed; nothing to push back.
        }

        // If one stone is left, return it; otherwise,
        // all stones are destroyed -> return 0.
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
// @lc code=end
