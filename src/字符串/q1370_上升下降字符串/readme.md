链接:  https://leetcode-cn.com/problems/increasing-decreasing-string/

#### q1370_上升下降字符串

给你一个字符串 s ，请你根据下面的算法重新构造字符串：

1. 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
2. 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
   重复步骤 2 ，直到你没法从 s 中选择字符。
3. 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
4. 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
5. 重复步骤 5 ，直到你没法从 s 中选择字符。
6. 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。

请你返回将 s 中字符重新排序后的 结果字符串 。



```
输入：s = "aaaabbbbcccc"
输出："abccbaabccba"
解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"

输入：s = "rat"
输出："art"
解释：单词 "rat" 在上述算法重排序以后变成 "art"

输入：s = "leetcode"
输出："cdelotee"

输入：s = "ggggggg"
输出："ggggggg"


```

**提示：**

- `1 <= s.length <= 500`
- `s` 只包含小写英文字母。

**思路**

```java
第一步, 可以计算出每个字符的个数, 并且字符是按照大小顺序排序的
例如 s = "aaaabbbbcccc"

a 4 b 4 c 4
第一轮
abc  剩余a3b3c3
第二轮
abccba 剩余a2b2c2
以此类推
abccbaabccba
    

```









