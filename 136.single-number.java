/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start

import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        // Approach 1: Using XOR (commented out)

        // XOR of a number with itself is 0, and XOR with 0 is the number itself.
        // So, all duplicate numbers cancel out, leaving only the unique number.

        // int result = 0;
        // for (int num: nums) {
        // result ^= num;
        // }

        // return result;

        // Approach 2: Using a Set

        // 1. Add numbers to the set.
        // 2. If a number is already present, it means we found a duplicate.
        // We remove the duplicates, so only the unique number remains at the end.

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            // Try to add the number to the set.
            // If add() returns false, the number was already present.
            boolean canAdd = set.add(num);

            // If we can't add (already exists), remove it (duplicate found).
            if (!canAdd)
                set.remove(num);
        }

        // After the loop, only the single number remains in the set.
        // Use iterator().next() to retrieve it.
        return set.iterator().next();
    }
}
// @lc code=end
