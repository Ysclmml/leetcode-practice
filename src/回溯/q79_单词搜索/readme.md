链接: https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/

q79_单词搜索

给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

**示例:**

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

```

**提示**

+ board 和 word 中只包含大写和小写英文字母。
+ `1 <= board.length <= 200`
+ `1 <= board[i].length <= 200`
+ `1 <= word.length <= 10^3`

**思路**

典型的深度优先搜索问题

```
1. 每个元素仅可访问一次, 需要配置同样的数组来标记每一个位置是否有被访问过
2. dfs的技巧之一: 在本题中, 搜索方向没有什么区别, 事先设置方向数组为上右下左
	[[0, -1], [1, 0], [0, 1], [-1, 0]]
3. 当遇到不匹配的时候, 需要进行回溯, 并且把访问数组的状态回溯
4. 当所有字母都匹配后, 则退出即可.
5. 本例中, 使用函数bool search(board, word, i, j, k, visited)函数来进行搜索
    其中: 
    board是原数组
    word是待搜索单词
    i,j 代表board的起始搜索位置
    k代表当前单词已经匹配了k个字符
    visited代表当前数组的访问情况
	search函数当不匹配时返回false或k==word.length时表示搜索到, 返回true
```



