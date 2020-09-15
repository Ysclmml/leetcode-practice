链接: https://leetcode-cn.com/problems/predict-the-winner/

q37_解数独

编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

+ 数字 1-9 在每一行只能出现一次。
+ 数字 1-9 在每一列只能出现一次。
+ 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

空白格用 '.' 表示。

![img](http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

一个数独。

![img](http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png)

答案被标成红色。

**Note:**

- 给定的数独序列只包含数字 `1-9` 和字符 `'.'` 。
- 你可以假设给定的数独只有唯一解。
- 给定数独永远是 `9x9` 形式的。

**思路**

```
按照人的思维解题数独
从第一行的空位开始尝试填数,遇到所有的都不行的就返回

这题的关键就是如何判断当前位置(i,j)是否在横行竖行9宫格里的约束下是否可以填
现在可以使用
row[i][n]表示第i行数字n是否有被使用过
col[j][n]表示第j列数字n是否有被使用过
line[i/3][j/3][n]表示数字n是否有在第i/3,j/3列个9宫格中出现过

最后的结束条件就是所有数字是否有被填写完毕, 然后一路返回
当前位置可以使用当前正在填写第几个数n来表示
即i = n / 9, j = n % 9; 这个就能表示第几行, 第几列了.
递归函数可以使用
// n表示当前正在填写第几个数, board表示原始数独数组
sudokuSolve(int n, int row[][], int col[][], int line[][][], int board[][]) {

}
```





