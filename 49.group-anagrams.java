/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // If the input array is empty, return an empty list
        if (strs.length == 0)
            return new ArrayList<>();

        // Create a map where the key is a string representing character counts
        // (signature of an anagram),
        // and the value is a list of strings (anagrams that match this signature)
        Map<String, List<String>> ansMap = new HashMap<String, List<String>>();

        // Create an array to count character frequencies
        int[] charCounts = new int[26]; // assuming only lowercase english letters

        // Iterate through each string in the input array
        for (String s : strs) {
            // Reset the character counts for the current word
            Arrays.fill(charCounts, 0);

            // Count the frequency of each character in the current string
            for (char c : s.toCharArray()) {
                charCounts[c - 'a']++;
            }

            // Build a key based on the character counts
            // Example: For "abb", the key would be "#1#2#0#0#0..."
            // This key uniquely identifies all anagrams of "abb"
            StringBuilder sb = new StringBuilder("");

            for (int n : charCounts) {
                // Adding a separator to avoid ambiguity (e.g., "11" vs "1#1")
                // Without this, counts like [11, 1] and [1, 11] would both become "111",
                sb.append("#");

                sb.append(n);
            }

            String key = sb.toString();

            // If this key is not in the map, initialize it with an empty list
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList<String>());
            }

            // Add the current string to the corresponding list of anagrams
            ansMap.get(key).add(s);
        }

        // Return all the grouped anagrams as a list of lists
        return new ArrayList<List<String>>(ansMap.values());
    }
}
// @lc code=end
