/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a hash set to store elements from the array
        Set<Integer> seen = new HashSet<Integer>();

        // Integrate through each elements in the array
        for (int num : nums) {

            // Check if element can be added to the hash set,
            // i.e., if the element is already in hash set or not
            boolean canAdd = seen.add(num);

            // If element cannot be added in to set, it's a duplicate element
            if (!canAdd)
                return true; // Return true since the array contains duplicate element
        }

        return false; // No duplicates found
    }
}
// @lc code=end
