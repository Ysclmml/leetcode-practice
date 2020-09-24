链接: https://leetcode-cn.com/problems/restore-ip-addresses/

q93_复原IP地址

+ 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
+ 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1"是 无效的 IP 地址。

```
输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]

输入：s = "0000"
输出：["0.0.0.0"]

输入：s = "1111"
输出：["1.1.1.1"]

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
```

**思路**

```java
// 长度小于4的或长度大于12的都是不合法的.

// 可以定义一个函数来判断当前分法是否合法. 
boolean check(int start, int end, char[] str) {
	// start 表示字符数组的起始坐标
    // end 表示终止坐标
    int len = end - start
    if (len > 1) if (str[start] == '0') return false;
    if (len > 3) return false;
    if (len == 3) {
        if (str[start] >= '3') return false;
        if (str[start] == '2' && (str[start + 1] > '5' || (str[start + 1] == '5' && str[end] > '5'))
            return false;
    }
    return true;
}
            
ip可以分为4段, 可以固定前面两段
for (int i = 0; i < 3 && i < length; i++){
      // 要判断剩下的长度 3 <= len <= 9, 不然后面的肯定不合法
     for (int j = i + 1; j < i + 4 && j < length; j++) {
         // 要判断剩下的长度 3 <= len <= 6, 不然后面的肯定不合法
         for (int k = j + 1; j < j + 4 && j < length; j++) {
         	// 要判断剩下的长度 1 <= len <=3 不然后面的肯定不合法
         	check()
     	}
     }
}
```











