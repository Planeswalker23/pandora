package io.walkers.planes.pandora.algorithm.array;

/**
 * <a href="https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/">
 * 剑指 Offer 11. 旋转数组的最小数字
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class MinArray {

    public static void main(String[] args) {
        MinArray demo = new MinArray();
        int[] array1 = new int[]{3, 4, 5, 1, 2};
        int result1 = demo.minArray(array1);
        System.out.println(result1);

        int[] array2 = new int[]{2, 2, 2, 0, 1};
        int result2 = demo.minArray(array2);
        System.out.println(result2);
    }

    public int minArray(int[] numbers) {
        int result = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            int cur = numbers[i];
            int next = numbers[i + 1];
            if (cur > next) {
                result = next;
                break;
            }
        }
        return result;
    }
}
