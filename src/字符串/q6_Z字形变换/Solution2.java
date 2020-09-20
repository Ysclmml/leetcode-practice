package 字符串.q6_Z字形变换;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 * create by yscl on 2020/9/20
 */
public class Solution2 {
    public String convert(String s, int numRows) {
        if (s.equals("") || numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) list.add(new StringBuilder());
        int curRow = 0;
        int dire = -1;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) dire = -dire;
            curRow += dire;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
