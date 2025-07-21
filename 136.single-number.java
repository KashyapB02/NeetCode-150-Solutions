/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        // int result = 0;
        // for (int num: nums) {
        // result ^= num;
        // }

        // return result;

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            boolean canAdd = set.add(num);
            if (!canAdd)
                set.remove(num);
        }

        return set.iterator().next();
    }
}
// @lc code=end
