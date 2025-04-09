/**
 * Problem: Encode and Decode Strings
 * Difficulty: Medium
 * Topic: Strings, Delimiter Encoding
 * Description:
 *   Design an algorithm to encode a list of strings to a single string and decode it back.
 *   This is useful for transmitting strings over a network or storing them.
 *
 * Approach:
 * - For encoding: use a length + delimiter (e.g., "5|apple") to safely encode each string.
 * - For decoding: read the length up to the '|' character, then extract that many characters.
 */

import java.util.*;

public class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String word : strs) {
            // Append length of word, delimiter '|', and the word itself
            sb.append(word.length()).append("|").append(word);
        }

        return sb.toString();  // Final encoded string
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int len = 0;

            // Read characters until '|' to get the length
            while (s.charAt(i) != '|') {
                len = len * 10 + (s.charAt(i) - '0');  // Convert char digit to int
                i++;
            }

            i++;  // Skip the '|' delimiter

            // Extract the word using the length we just found
            String word = s.substring(i, i + len);
            result.add(word);

            i += len;  // Move pointer to start of next encoded string
        }

        return result;
    }
}
