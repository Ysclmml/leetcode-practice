package 字符串.q9_回文数;

/**
 * Solution
 * create by yscl on 2020/9/19
 */
public class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) return false;
        }
        return true;
    }
}
