package 字符串.q6_Z字形变换;

import com.sun.rowset.internal.Row;

/**
 * Solution
 * create by yscl on 2020/9/20
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s.equals("")) return "";
        else if (numRows == 1) return s;
        // 先判断一共需要多少列
        int len = s.length();
        // 每组的元素个数
        int groupNum = numRows * 2 - 2 ;
        // 准备计算一共有多少列
        int numCols = len / groupNum * (groupNum - numRows + 1);
        int tmp = len % groupNum;
        if (tmp <= numRows) numCols++;
        else numCols = numCols + 1 + tmp - numRows;
        // 存储z变换后数组
        char[][] res = new char[numRows][numCols];
        for (int i = 0, count=0, j = 0; i < len; i++) {
            if (count < numRows) {
                res[count][j] = s.charAt(i);
            } else {
                j++;
                res[numRows - (count - numRows + 2)][j] = s.charAt(i);
            }
            count++;
            if (count == groupNum) {
                count = 0;
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (res[i][j] != '\0') sb.append(res[i][j]);
            }
        }
        return sb.toString();
    }
}
