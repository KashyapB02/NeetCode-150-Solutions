/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length())
            return false;

        // Create an array to count character frequencies
        int[] charCounts = new int[26]; // assuming only lowercase english letters

        // Increment count for each character in 's' and decrement for each character in
        // 't'
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCounts) {
            if (count != 0)
                return false;
        }

        return true; // All counts are zero, so 't' is an anagram of 's'
    }
}
// @lc code=end
