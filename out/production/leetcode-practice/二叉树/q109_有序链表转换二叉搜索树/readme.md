链接:   https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/

q109_有序链表转换二叉搜索树

给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

**示例:**

例如，给出

```
给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

```

**思路**

```
因为链表起始是有序的, 所以要满足搜索树的要求, 
可以每次都是左平分处理, 这样保证左右子树的高度差永远都是最多差一.

思路可以用递归来做, 用二分的思想

node = new Node(val)
mid = (left + right) / 2
node.left = travel(left, mid - 1)
node.right = travel(mid + 1, right)

```







