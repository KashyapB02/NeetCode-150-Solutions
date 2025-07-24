/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store numbers and their indices
        Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current number
            int required = target - nums[i];

            // Check if the complement is already in the map
            if (mapping.containsKey(required)) {
                // If found, return the indices of the complement and the current number
                return new int[] { mapping.get(required), i };
            }

            // If not found, add the current number and its index to the map
            mapping.put(nums[i], i);
        }

        // Return an empty array if no solution is found (this case will not occur as
        // per problem constraints)
        return new int[0];
    }
}
// @lc code=end
