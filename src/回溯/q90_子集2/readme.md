链接:   https://leetcode-cn.com/problems/subsets-ii/

q90_子集2

给定一个可能包含重复元素的整数数组 ***nums***，返回该数组所有可能的子集（幂集）。

**说明：**解集不能包含重复的子集。

**示例 1:**

```
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

**思路**

```
使用回溯法, 需要保证不能重复, 只需要在回溯的一开始避免即可. 
当然需要先排序原数组.

```









