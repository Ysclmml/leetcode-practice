链接:   https://leetcode-cn.com/problems/path-sum-ii/

q113_路径总和2

给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

**示例:**

```
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
```

返回 

```
[
   [5,4,11,2],
   [5,8,4,5]
]
```



**思路**

```
先序遍历, 遇到叶节点统计总和, 判断是否存在.
```







