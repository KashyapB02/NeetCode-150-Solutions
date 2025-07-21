/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        // for (int num: nums) {
        // countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        // if (countMap.get(num) > 1) return true;
        // }

        // return false;

        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            boolean canAdd = seen.add(num);
            if (!canAdd)
                return true;
        }

        return false;
    }
}
// @lc code=end
