package io.walkers.planes.pandora.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字 <a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">...</a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        FindRepeatNumber demo = new FindRepeatNumber();
        int[] array = new int[]{2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = demo.findRepeatNumber(array);
        System.out.println(repeatNumber);
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                result = num;
                break;
            }
        }
        return result;
    }
}
