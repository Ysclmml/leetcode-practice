package 动态规划.q978_最长湍流子数组;

/**
 * Solution
 * create by yscl on 2020/9/11
 */
public class Solution {
    public int maxTurbulenceSize(int[] A) {
        int max = 1;
        int flag = -1;
        int curLen = 1;
        if (A.length == 0) return 0;
        for (int i = 1; i < A.length; i++) {
            // flag的值是-1 0 1 对应于 == < >
            if (flag == -1) {
                if (A[i] < A[i - 1]) {
                    max = Math.max(++curLen, max);
                    flag = 0;
                } else if (A[i] > A[i - 1]){
                    max = Math.max(++curLen, max);
                    flag = 1;
                } else {
                    curLen = 1;
                }
            } else if (flag == 0){
                if (A[i] > A[i - 1]) {
                    max = Math.max(++curLen, max);
                    flag = 1;
                } else if (A[i] < A[i - 1]) {
                    curLen = 2;
                } else {
                    flag = -1;
                    curLen = 1;
                }
            } else {
                if (A[i] < A[i - 1]) {
                    max = Math.max(++curLen, max);
                    flag = 0;
                } else if (A[i] > A[i - 1]) {
                    curLen = 2;
                } else {
                    flag = -1;
                    curLen = 1;
                }
            }
        }
        return max;
    }
}
