链接:  https://leetcode-cn.com/problems/spiral-matrix-ii/

q59_螺旋矩阵2

​	给定一个正整数 *n*，生成一个包含 1 到 *n*2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

**示例:**

```
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```

**思路**

```java
使用i,j表示当前坐标. 初始化都是0
用(0, 1), (1, 0), (0, -1), ( -1, 0)来表示右下左上的方位操作, 
判断下一个坐标是否越界或已经访问过(已经赋值, 不是0), 如果符合, 则改变下一个方向, 直到元素技术为n*n为止.
```











