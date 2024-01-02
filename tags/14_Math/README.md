# Math
This folder contains problems and solutions related to mathamatics.

# LC169_MajorityElement.java
* [Problem Link](https://leetcode.com/problems/majority-element/)
* [Solution Link](../../LC0001_1000/LC0161_0170/LC0169_MajorityElement.java)
* Idea: Boyer-Moore Voting Algorithm. The key point is that the majority element will always be the last element that stays in the `count` variable.

# LC189_RotateArray.java
* [Problem Link](https://leetcode.com/problems/rotate-array/)
* [Solution Link](../../LC0001_1000/LC0181_0190/LC0189_RotateArray.java)
* Idea: reverse the whole array, then reverse the first `k` elements, and reverse the rest elements.

# LC238_ProductOfArrayExceptSelf.java
* [Problem Link](https://leetcode.com/problems/product-of-array-except-self/)
* [Solution Link](../../LC0001_1000/LC0231_0240/LC0238_ProductOfArrayExceptSelf.java)
* Idea: use two arrays or use two variables to store the product of all elements to the left and right of the current element, respectively.