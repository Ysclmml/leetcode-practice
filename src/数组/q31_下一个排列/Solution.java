package 数组.q31_下一个排列;

/**
 * Solution
 * create by yscl on 2020/9/22
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int start = len - 2;
        while (start >= 0 && nums[start] >= nums[start + 1]) {
            start--;
        }
        // 交换对应位置与最后的数
        if (start >= 0) {
            // 找到第一个比nums[start]大的数
            int t = len - 1;
            while (nums[t] <= nums[start]) {
                t--;
            }
            int tmp = nums[t];
            nums[t] = nums[start];
            nums[start] = tmp;
        }
        // start位置右侧的数做对称变换
        for (int i = 0; i < (len - start - 1) / 2; i++) {
            int tmp = nums[i + start + 1];
            nums[i + start + 1] = nums[len - 1 - i];
            nums[len - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{1, 5, 4, 3, 2};
        int[] nums = new int[]{2, 5, 4, 3, 1};
        new Solution().nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
