package 字符串.q20表示数值的字符串;

import java.util.regex.Pattern;

/**
 * isNumber
 * create by yscl on 2020/9/14
 */
public class Solution {
    public boolean isNumber(String s) {
        String pattern = "^[-+]?((\\d+(\\.\\d*)?)|(\\.\\d+))([eE][-+]?\\d+)?$";
        Pattern p = Pattern.compile(pattern);
        return p.matcher(s.trim()).find();
    }
}
