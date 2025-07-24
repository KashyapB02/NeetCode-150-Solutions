/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start

import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        // Approach 1: Using a HashSet to track seen numbers

        // Create a HashSet to store all numbers from the array
        HashSet<Integer> seen = new HashSet<Integer>();

        // Iterate through given array and add all the numbers to set
        for (int num : nums) {
            seen.add(num);
        }

        // Iterate through all numbers from 0 to n (where n = nums.length)
        // The missing number will be the one not present in the set
        for (int i = 0; i <= nums.length; i++) {
            if (!seen.contains(i))
                return i;
        }

        return 0; // This line is never actually reached if input is valid

        // Approach 2 (Commented): Using the sum formula

        // Concept:
        // - The numbers are supposed to be in the range [0, n].
        // - The sum of first n natural numbers is n // (n + 1) / 2.

        // If we subtract the sum of the given array from this expected sum,
        // the difference will be the missing number.

        // This approach is O(n) time and O(1) space (no extra data structures).

        // int length = nums.length;
        // int expectedSum = ((length) * (length + 1)) / 2;
        // int actualSum = 0;

        // for (int num : nums)
        // actualSum += num;

        // return expectedSum - actualSum;
    }
}
// @lc code=end
