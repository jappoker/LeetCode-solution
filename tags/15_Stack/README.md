# Stack
This folder contains problems and solutions related to Stack

# General Stack
## LC20 Valid Parentheses
* [Problem Link](https://leetcode.com/problems/valid-parentheses/)
* [Solution Link](../../LC0001_1000/LC0001_0100/LC0020_ValidParentheses.java)


# Monotonic Stack
## LC316 Remove Duplicate Letters
* [Problem Link](https://leetcode.com/problems/remove-duplicate-letters/)
* [Solution Link](../../LC0301_0400/LC0316_RemoveDuplicateLetters.java)
* Idea: Monotonic Stack. 
  * Variables:
    * `stack` is a `StringBuilder`, used to store the characters.
    * `count` is `int[26]`, used to store the number of each character in `s`.
    * `visited` is `boolean[26]`, used to store whether a character is in the stack.
  * Conditions: 
    * If `visited[s.charAt(i) - 'a']`, skip this character. 
    * Otherwise, if `stack.peek() > s.charAt(i)` and `count[stack.peek() - 'a'] > 0`, pop `stack.peek()` and set `visited[stack.peek() - 'a']` to false. 
    * Then, push `s.charAt(i)` to `stack` and set `visited[s.charAt(i) - 'a']` to true. Finally, decrement `count[s.charAt(i) - 'a']`.
  * Time Complexity: $O(n)$, Space Complexity: $O(1)$