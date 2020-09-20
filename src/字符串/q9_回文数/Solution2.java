package 字符串.q9_回文数;

/**
 * Solution
 * create by yscl on 2020/9/19
 */
public class Solution2 {
    public boolean isPalindrome(int x) {
        // 先获取x有多少位长
        if (x < 0) return false;
        int tmp = 1;
        int y = x / 10;
        while (y != 0) {
            y /= 10;
            tmp *= 10;
        }
        while (x != 0) {
            if (x / tmp != x % 10) return false;
            x = x % tmp;
            x /= 10;
            tmp /= 100;
        }
        return true;
    }
}
