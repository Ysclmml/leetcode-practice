链接: https://leetcode-cn.com/problems/palindrome-number/

q6_Z字形变换

将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 `"LEETCODEISHIRING"` 行数为 3 时，排列如下：

```
L   C   I   R
E T O E S I I G
E   D   H   N
```

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：`"LCIRETOESIIGEDHN"`。

请你实现这个将字符串进行指定行数变换的函数：

```
string convert(string s, int numRows);
```

**示例：**

```
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"

L     D     R
E   O E   I I
E C   I H   N
T     S     G
```

**思路**

```
实现声明一个char[][]数组, 然后依次往里面填数, 最后按照行输出即可
方法一比较菜..
看了官方题解之后, 发现自己的写法有太多的空间浪费, 时间也浪费了
可以声明一个List[Stringbuilder], 每一行表示非空字符, 行数表示最后的结果 最后把这个数组按行数输出即可

实现填写字符按照从上到下, 从下到上, 只有当到达边界后需要转变方向
```





