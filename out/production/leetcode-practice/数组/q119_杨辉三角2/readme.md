链接:   https://leetcode-cn.com/problems/pascals-triangle-ii/

q119_杨辉三角2

给定一个非负索引 *k*，其中 *k* ≤ 33，返回杨辉三角的第 *k* 行。

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

在杨辉三角中，每个数是它左上方和右上方的数的和。

```
输入: 3
输出: [1,3,3,1]
```

**进阶：**

你可以优化你的算法到 *O*(*k*) 空间复杂度吗？

**思路**

```
nums[k][i] = nums[k-1][i-1] + nums[k-1][i] i>=1 && i<=k-1

int nums[k]
// 需要保存上一个tmp也就是当前需要覆盖的值
for (int i = 1; i < k - 1; i++) {
	nums[i] = nums[i-1] + tmp;
	int tmp = nums[i]
}

```







