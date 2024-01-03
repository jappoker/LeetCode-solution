# HashSet

# HashMap
## LC01_TwoSum
* [LC01_TwoSum](https://leetcode.com/problems/two-sum/description/)
* [Solution](../../LC0001_1000/LC0001_0100/LC0001_TwoSum.java)
* Idea: HashMap. 
  * Variables:
    * `map` is a HashMap, key is the number, value is the index.
  * Conditions: 
    * If `map.containsKey(target - nums[i])`, return `[map.get(target - nums[i]), i]`. Otherwise, put `nums[i]` to `map`.
