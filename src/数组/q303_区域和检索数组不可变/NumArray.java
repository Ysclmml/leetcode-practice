package 数组.q303_区域和检索数组不可变;

import java.util.Arrays;

public class NumArray {
    private int[] nums;
    private int[] sums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        // 保存和的数组
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        System.out.println(Arrays.toString(sums));
    }

    public int sumRange(int i, int j) {
        return sums[j] - sums[i] + nums[i];
    }

    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(0, 5));
        System.out.println(array.sumRange(2, 5));
    }
}
