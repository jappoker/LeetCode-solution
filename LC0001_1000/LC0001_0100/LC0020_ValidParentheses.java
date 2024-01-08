package LC0001_1000.LC0001_0100;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 */

public class LC0020_ValidParentheses {

    /**
     * Solution 1: Stack (Built-in Stack)
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * @param s
     * @return boolean
     */
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> parenthesePair = new HashMap<>();
        parenthesePair.put(')', '(');
        parenthesePair.put(']', '[');
        parenthesePair.put('}', '{');
        for(char c: s.toCharArray()){
            if(!parenthesePair.containsKey(c)){
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.peek()!= parenthesePair.get(c)) return false;
                else stack.pop();
            }
        }
        return stack.size() == 0 ? true: false;
    }

    public static void main(String[] args) {
        System.out.println("20. Valid Parentheses [easy]");
        LC0020_ValidParentheses solution = new LC0020_ValidParentheses();
        System.out.println(solution.isValid1("()")); // true
        System.out.println(solution.isValid1("()[]{}")); // true
        System.out.println(solution.isValid1("(]")); // false
        System.out.println(solution.isValid1("([)]")); // false
    }
    
}
