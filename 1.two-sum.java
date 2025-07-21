/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        mapping.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int required = target - nums[i];

            if (mapping.containsKey(required)) {
                return new int[] { mapping.get(required), i };
            }

            mapping.put(nums[i], i);
        }

        return new int[0];
    }
}
// @lc code=end
