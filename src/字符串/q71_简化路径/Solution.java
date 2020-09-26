package 字符串.q71_简化路径;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution的模板
 * create by yscl on 2020/9/22
 */
public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        int len = path.length();
        char last = '/';
        for (int i = 1; i < len; i++){
            // 遇到连续的斜杠忽略
            if (path.charAt(i) == '/') {
                if (last != '/' && last != '.') {
                    sb.append('/');
                }
                last = path.charAt(i);
            } else if (isLetter(path.charAt(i))) {
                sb.append(path.charAt(i));
                last = path.charAt(i);
            } else if (path.charAt(i) == '.') {
                // 直接判断当前下面是不是都是.
                if (isLetter(last)) {
                    sb.append('.');
                    continue;
                }
                int count = 1;
                while(++i < len && path.charAt(i) == '.') {
                    count++;
                }
                if (i < len && isLetter(path.charAt(i))) {
                    for (int k = 0; k < count; k++)
                        sb.append('.');
                } else {
                    if (count > 2) {
                        for (int k = 0; k < count; k++)
                            sb.append('.');
                        last = 'a';
                    }

                    if (count == 2) {
                        int tempLen = sb.length();
                        if (tempLen > 1 && sb.charAt(tempLen - 1) == '/') sb.deleteCharAt(tempLen - 1);
                        sb.delete(sb.lastIndexOf("/") + 1, sb.length());
                    }
                }
                i--;
            }
        }
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '/')
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private boolean isLetter(char ch) {
        return ch != '.'  && ch != '/';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
    }

    @Test
    public void testSolution() {
        Solution s = new Solution();
        assertEquals(new Solution().simplifyPath("/a/./b/../../c/"), "/c");
        assertEquals(new Solution().simplifyPath("/a/../../b/../c//.//"), "/c");
        assertEquals(new Solution().simplifyPath("/a//b////c/d//././/.."), "/a/b/c");
        assertEquals(new Solution().simplifyPath("/abafda/fadff////asdf/../adfa/aaa/../af/adsf..//"), "/abafda/fadff/adfa/af/adsf..");
        assertEquals(new Solution().simplifyPath("/..."), "/...");
        assertEquals(new Solution().simplifyPath("/a/b/c/.../d"), "/a/b/c/.../d");
        assertEquals(new Solution().simplifyPath("/..hidden"), "/..hidden");
        assertEquals(new Solution().simplifyPath("/home/foo/.ssh/authorized_keys/"), "/home/foo/.ssh/authorized_keys");
    }

    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                System.out.print(nums[i]);
            } else {
                System.out.print(", " + nums[i]);
            }
        }
        System.out.println("]");
    }
}
