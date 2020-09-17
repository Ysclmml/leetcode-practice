链接:https://leetcode-cn.com/problems/combination-sum-ii/

q40_组合总和2

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

**说明:**

+ 所有数字（包括目标数）都是正整数。
+ 解集不能包含重复的组合。 

```
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
```

**思路**

```
思路与 `组合总和I` 一样, 只是增加了一个不能使用同样的数字
先排序, 
solve(target, cur, index, tmp, reslut) 递归时 index+1即可

需要注意的是要防止上一个重复的数重复进入循环回溯
```





