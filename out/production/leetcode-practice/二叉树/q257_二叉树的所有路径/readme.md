链接: https://leetcode-cn.com/problems/binary-tree-paths/

q257_二叉树的所有路径

给定一个二叉树，返回所有从根节点到叶子节点的路径。

**说明:** 叶子节点是指没有子节点的节点。

```
输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
```

**思路**

```
从根节点开始遍历, 记录下当前路径
例如一开始是[1]
left有值, 路径保存为[1, 2]
如果left为null了, 返回
如果right有值, 加上当前值 [1,2,5], 
如果左右节点都没值, 表示到了根节点, 添加当前路径到总的结果集中, 
并pop掉最后的5
前序遍历, 寻找叶节点, 加入结果集中
void findLeafPath(root, path, res) {
	if (root == null) return
	path.add(root.val)
	findLeafPath(root.left, path)
	findleafPath(root.right, path)
	// 判断当前节点是否有左右节点, 如果没有, 则表示是叶节点
	res.add(path)
	path.remove(root.val) // 移除当前路径上的最后一个元素
}

保存路径方式可以使用Stringbuilder
```





