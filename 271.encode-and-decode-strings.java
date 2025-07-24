/*
 * @lc app=leetcode id=271 lang=java
 *
 * [271] Encode and Decode Strings
 */

// @lc code=start

import java.util.*;

class Solution {
    /**
     * Encodes a list of strings into a single string.
     * Uses a unique delimiter (char 257) to separate strings
     * and a special character (char 258) to represent an empty list.
     */

    public String encode(List<String> strs) {
        // If the list is empty, return a unique single character (char 258)
        // This avoids confusion between empty list and an empty string
        if (strs.size() == 0)
            return Character.toString((char) 258);

        // Use char 257 as a delimiter between strings because it is unlikely
        // to appear in normal input strings (outside ASCII range)
        String hash = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder("");

        // Append each string followed by the delimiter
        for (String s : strs) {
            sb.append(s);
            sb.append(hash);
        }

        // Remove the last delimiter to avoid trailing delimiter issue
        sb.deleteCharAt(sb.length() - 1);

        // Return the final encoded string
        return sb.toString();
    }

    /**
     * Decodes a single string back into the original list of strings.
     * Splits using the unique delimiter (char 257).
     */
    public List<String> decode(String str) {
        // If the encoded string is the special character (char 258),
        // it represents an empty list
        if (str.equals(Character.toString((char) 258)))
            return new ArrayList<String>();

        // Use the same unique delimiter (char 257) used during encoding
        String hash = Character.toString((char) 257);

        // Split the encoded string by the delimiter and return as a list
        // The "-1" flag ensures trailing empty strings are preserved
        return Arrays.asList(str.split(hash, -1));
    }
}
// @lc code=end
