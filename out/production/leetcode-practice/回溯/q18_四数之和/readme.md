链接:  https://leetcode-cn.com/problems/4sum/

q18_四数之和

给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

**注意：**

答案中不可以包含重复的四元组。

**示例：**

```
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```

**思路**

```java
回溯法
处理不能重复的方法都是类似, 先排序
用一个last的变量标记, 遇到重复的continue就是了
递归函数模板
private void dfs(int index, int[] nums, List<Integer> tmp, List<List<Integer>> res) {
    if (tmp.length == 4) {
        res.add()
        return;
    }
}
```





