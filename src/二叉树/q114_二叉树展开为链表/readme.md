链接:   https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/

q114_二叉树展开为链表

给定一个二叉树，[原地](https://baike.baidu.com/item/原地算法/8010757)将它展开为一个单链表。

例如，给定二叉树

**示例:**

```
    1
   / \
  2   5
 / \   \
3   4   6
```

将其展开为：

```
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```



**思路**

```
先序遍历, 
遇到有两个子节点的节点, 
就把当前节点的左节点置空, 然后递归的处理剩下的节点, 把原来的右节点指向剩下的节点的尾节点
如上面的例子所示:
    1
   / \
  2   5
 / \   \
3   4   6

先遍历1节点, 有左右两个节点, 然后把1节点的左侧置空, 右侧处理剩下的
  2
 / \
3   4
节点
处理2,3,4节点, 与上面方法一致
2左侧置空, 2的右侧指向3. 3是叶节点了, 所以返回3, 3指向原来的4节点
此时4节点时叶节点, 返回4节点
原来1的右侧指向2节点 返回的4节点指向原来的5节点. 
```







