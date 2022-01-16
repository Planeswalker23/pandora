package io.walkers.planes.pandora.algorithm.array;

/**
 * <a href="https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof//">
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class MissingNumber2 {

    public static void main(String[] args) {
        MissingNumber2 demo = new MissingNumber2();
        int[] array1 = new int[]{0, 1, 3};
        int result1 = demo.missingNumber(array1);
        System.out.println("result1: " + result1);

        int[] array2 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        int result2 = demo.missingNumber(array2);
        System.out.println("result2: " + result2);
    }

    public int missingNumber(int[] nums) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i;
    }
}
