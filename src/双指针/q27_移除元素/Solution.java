package 双指针.q27_移除元素;

/**
 * Solution
 * create by yscl on 2020/9/21
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        // i指针顺序遍历数组, j指针从右边数起
        int i = 0, j = len - 1;
        while (i <= j) {
            // 遇到第一个待删除的数
            while (i <= j && nums[i] != val) {
                i++;
            }
            // 遇到第一个不删除的数
            while (i <= j && nums[j] == val) {
                j--;
            }
            if (i <= j) {
                // 将不删除的数放到待删除的数上
                nums[i] = nums[j];
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new Solution().removeElement(ints, 2));
        for (int i : ints) {
            System.out.print(i + " ");
        }
        ints = new int[]{3, 2, 2, 3};
        System.out.println(new Solution().removeElement(ints, 3));
        for (int i : ints) {
            System.out.print(i + " ");
        }
        ints = new int[]{1};
        System.out.println(new Solution().removeElement(ints, 1));
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
