链接:  https://leetcode-cn.com/problems/excel-sheet-column-title/

q168_Excel表列名称

给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

```
  	1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...

```

```
输入: 1
输出: "A"

输入: 28
输出: "AB"

输入: 701
输出: "ZY"
```

**思路**

```java
本质是一个十进制转26进制的思路
短除法, 最后倒序输出即可
    28 / 26 = 1 -> A
    28 - 26 * 1 = 2 -> B
```











