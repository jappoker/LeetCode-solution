# LeetCode Solution

My leetcode solution in Java, with main thread + test cases, and derivation.

# File Structure

```
LeetCode_Solutions
│
├── 0001_1000
│ └── 0001_0100
│   ├── LC1_TwoSum.java
│   └── LC2_AddTwoNumbers.java
│
├── tags
│ ├── 01_Sorting.md
│ └── 02_TwoPointers.md
```

## Navigation

- `0001-1000/0001-0100`: Contains solutions for problems 1 to 100.
- `tags`: Contains markdown files with explanations and notes categorized by problem-solving techniques or tags.

# How to grok a LeetCode problem in an interview
7 Steps to solve a LeetCode problem in an interview:
1. Clarify the problem
   1. The problem statement: what is the problem asking for?
   2. The input and output: type, range, size, format, etc.
2. Ask for/design test cases, edge cases, and constraints
   1. overflow, underflow, null, empty, negative, etc.
3. Think out loud
   1. Think about the brute force solution
   2. Demonstrate the thought process
4. Optimize the solution
   1. For DP problems, think about why need memoization, how to get the state transition equation, and how to initialize the state
   2. For divide-and-conquer problems, think about how to divide the problem into subproblems, and how to combine the solutions of subproblems
   3. For recursive problems, think about the base case, and how to reduce the problem into subproblems
   4. For greedy problems, think about how to make the greedy choice, and how to prove the greedy choice is optimal
5. Code the solution
   1. Write corner cases first
   2. Comment the code
   3. Be aware of the naming convention
6. Test the solution
7. Discuss the time and space complexity, and trade-offs
   1. From macro to micro, i.e., for divide-and-conquer algorithms
   2. From micro to macro, i.e., for recursive algorithms