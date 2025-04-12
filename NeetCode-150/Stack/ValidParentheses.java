/**
 * Problem: Valid Parentheses
 * Difficulty: Easy
 * Topic: Stack, String
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * A string is valid if:
 * - Open brackets are closed by the same type of brackets.
 * - Open brackets are closed in the correct order.
 */

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Push all opening brackets to the stack
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }

            // If it's a closing bracket
            else if (c == ')' || c == '}' || c == ']') {
                // No opening bracket to match with
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                // Check for matching pair
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched properly
        return st.isEmpty();
    }
}

/**
 * 📘 How this code works:
 *
 * We iterate through each character in the input string. If the character is an opening bracket
 * ('(', '{', or '['), we push it onto the stack — expecting a matching closing bracket later.
 *
 * When we encounter a closing bracket (')', '}', or ']'), we check:
 * - If the stack is empty → there's no corresponding opening → return false.
 * - Otherwise, we pop the top of the stack and ensure it matches the current closing bracket.
 *   If it doesn't, we return false.
 *
 * The core insight is that the stack keeps track of the most recent unmatched opening bracket.
 * Because closing brackets must match the **last unmatched** open bracket, this is a classic use of
 * a Last-In-First-Out (LIFO) data structure.
 *
 * ✅ We return true at the end only if the stack is empty — meaning every opening bracket had a match.
 */
