链接: https://leetcode-cn.com/problems/invert-binary-tree/

q226_翻转二叉树

翻转一棵二叉树。

**说明:** 叶子节点是指没有子节点的节点。

```
输入:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出: 
     4
   /   \
  7     2
 / \   / \
9   6 3   1

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
```

备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。

**思路**

```
比较简单, 只是单纯的左右翻转
只需要在先序遍历的时候, 同时创建一棵树并且左右节点互换即可
基础写法:
if (root != null) {
	newRoot = new TreeNode(val);
	left = travel(root.left)
	right = travel(root.right)
	newRoot.left = right;
	newRoot.right = left;
	return newroot;
}
```





