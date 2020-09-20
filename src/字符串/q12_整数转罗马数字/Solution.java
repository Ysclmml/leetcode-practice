package 字符串.q12_整数转罗马数字;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 * create by yscl on 2020/9/20
 */
public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = initMap();
        StringBuilder sb = new StringBuilder();
        int[] divided = new int[]{1000, 100, 10, 1};
        for (int d : divided) {
            int tmp = num / d;
            if (tmp != 0) {
                sb.append(map.get(tmp * d));
                num = num % d;
            }
        }
        return sb.toString();
    }

    private Map<Integer, String> initMap() {

        Map<Integer, String> map = new HashMap<Integer, String>(){{
           put(1, "I");
           put(2, "II");
           put(3, "III");
           put(4, "IV");
           put(5, "V");
           put(6, "VI");
           put(7, "VII");
           put(8, "VIII");
           put(9, "IX");
           put(10, "X");
           put(20, "XX");
           put(30, "XXX");
           put(40, "XL");
           put(50, "L");
           put(60, "LX");
           put(70, "LXX");
           put(80, "LXXX");
           put(90, "XC");
           put(100, "C");
           put(200, "CC");
           put(300, "CCC");
           put(400, "CD");
           put(500, "D");
           put(600, "DC");
           put(700, "DCC");
           put(800, "DCCC");
           put(900, "CM");
           put(1000, "M");
           put(2000, "MM");
           put(3000, "MMM");
        }};
        return map;
    }
}
