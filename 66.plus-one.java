/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[] plusOne(int[] digits) {
        // Create the dynamic List to store the result
        // since we don't know if the size might increase (e.g., 999 + 1 = 1000)
        List<Integer> result = new ArrayList<Integer>();

        // Start with a carry of 1, because we want to add 1 to the number
        int carry = 1;

        // Traverse the digits array from the last digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // Add the current digit and the carry
            int sum = digits[i] + carry;

            // The current digit in the result is sum % 10
            // if sum=10, we add 0 and carry forward 1
            result.add(sum % 10);

            // Update carry: sum / 10 (it will be 1 if sum >= 10, otherwise 0)
            carry = sum / 10;
        }

        // After processing all digits, if there's still a carry left, add it
        if (carry > 0) {
            result.add(carry);
        }

        // The digits were added in reverse order,
        // so we reverse the list to get the correct order
        Collections.reverse(result);

        // Convert the List<Integer> to an int[] for the final result
        int[] finalResult = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }

        return finalResult;
    }
}
// @lc code=end
