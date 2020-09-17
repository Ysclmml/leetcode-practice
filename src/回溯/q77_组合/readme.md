链接: https://leetcode-cn.com/problems/top-k-frequent-elements/

q77_组合

给定两个整数 *n* 和 *k*，返回 1 ... *n* 中所有可能的 *k* 个数的组合。

```
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

**思路**

```
回溯, 每次从当前可以使用的数中获取一个, 然后组合, 当长度等于k时, 就停止回溯, 增加一种情况
n = 4, k = 2
// set代表当前可以使用的数
set = {}
len = set.length()
for (i = 1; i <= n; i++) {
	if (len==n) res.add(tmp) 
	else{
	if (i not in set)
		set.add(i)
		tmp[len] = i
		solve(set, res, tmp)
		set.pop(i)
	}
	
}
```





