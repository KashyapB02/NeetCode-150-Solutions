/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int missingNumber(int[] nums) {
        // List<Integer> seen = new ArrayList<Integer>();
        // for (int num: nums) {
        // seen.add(num);
        // }

        // for (int i = 0; i <= nums.length; i++) {
        // if (!seen.contains(i)) return i;
        // }

        // return 0;

        // Set<Integer> seen = new HashSet<Integer>();
        // for (int num: nums) {
        // seen.add(num);
        // }

        // for (int i = 0; i <= nums.length; i++) {
        // if (!seen.contains(i)) return i;
        // }

        // return 0;

        int length = nums.length;
        int expectedSum = ((length) * (length + 1)) / 2;
        int actualSum = 0;

        for (int num : nums)
            actualSum += num;

        return expectedSum - actualSum;
    }
}
// @lc code=end
