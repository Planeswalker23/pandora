package io.walkers.planes.pandora.algorithm.array;

/**
 * <a href="https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/">
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class SearchNumber1 {

    public static void main(String[] args) {
        SearchNumber1 demo = new SearchNumber1();
        int[] array = new int[]{5, 7, 7, 8, 8, 10};
        int result1 = demo.search(array, 8);
        System.out.println("1: " + result1);

        int result2 = demo.search(array, 6);
        System.out.println("2: " + result2);
    }

    public int search(int[] nums, int target) {
        boolean match = false;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                match = true;
                result++;
            } else {
                match = false;
            }
            if (!match && target < nums[i]) {
                break;
            }
        }
        return result;
    }
}
