/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // prefixProducts[i] will store the product of all elements to the left of index
        // 'i'
        int[] prefixProducts = new int[nums.length];

        // postfixProducts[i] will store the product of all elements to the right of
        // index 'i'
        int[] postfixProducts = new int[nums.length];

        // For the first element, there is nothing on the left, so set prefix product to
        // 1 because multiplying by 1 does not affect the result
        prefixProducts[0] = 1;

        // For the last element, there is nothing on the right, so set postfix product
        // to 1
        postfixProducts[nums.length - 1] = 1;

        // Iterate through nums array to build prefixProducts:
        // prefixProducts[i] = nums[0] * nums[1] * ... * nums[i-1]
        for (int i = 1; i < nums.length; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        // Iterate through nums array (reverse order) to build postfixProducts:
        // postfixProducts[i] = nums[i+1] * nums[i+2] * ... * nums[nums.length-1]
        for (int i = nums.length - 2; i >= 0; i--) {
            postfixProducts[i] = postfixProducts[i + 1] * nums[i + 1];
        }

        int[] ans = new int[nums.length];

        // The result for each index i is simply:
        // product of all elements to the left * product of all elements to the right
        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefixProducts[i] * postfixProducts[i];
        }

        return ans;
    }
}
// @lc code=end
