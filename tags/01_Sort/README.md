# Sort
This folder contains problems and solutions related to sorting algorithms.

# Bucket Sort
## LC274 H-Index
* [Problem Link](https://leetcode.com/problems/h-index/)
* [Solution Link](../../LC0001_1000/LC0201_0300/LC274_HIndex.java)
* Idea: use an array (n-size bucket) to store the number of papers that have `i` citations. If `i` is larger than the length of the array, put it to the last bucket. Then, traverse the array from the end, and find the first `i` that `sum >= i`. The answer is `i`.