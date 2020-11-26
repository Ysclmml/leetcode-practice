链接:   https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

q105_从前序与中序遍历序列构造二叉树

根据一棵树的前序遍历与中序遍历构造二叉树。

**注意:**
		你可以假设树中没有重复的元素。

例如，给出

```
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]

```

返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```

**思路**

```
按照人的思路来构造树
现在前序遍历 preorder = [3,9,10,20,15,7]
中序遍历 inorder = [10,9,3,15,20,7]

事先可以先把中序的遍历的元素及其索引用map存储起来, 来加快索引速度.

遍历前序的数组
第一个确认是主根3, 然后找到中序遍历3所在的位置index, 左侧的元素在根3的左侧, 右侧的元素在根3的右侧
所以可以写出这样的递归方程
node = new Node(val)
node.left = inorder[left, index-1]
node.right = inorder[index+1, right]
return node
根据当前的left和right来判断递归的结束条件.
   3
   / \
  9  20
 /  /  \
10  15   7
```







