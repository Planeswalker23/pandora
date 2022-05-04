package io.walkers.planes.pandora.algorithm.array;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-integer/">
 * 7. 整数反转
 * </a>
 *
 * @author planeswalker23
 * @date 2022/5/4
 */
public class AssaultCamp2ReverseInteger {

    public static int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        // 正数标记，运算时视为正数
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x = -x;
        }
        int result = 0;
        while (x != 0) {
            int curNumber = x % 10;
            x /= 10;
            // 判断溢出，若溢出该等式不成立
            if ((result * 10 + curNumber) / 10 != result) {
                return 0;
            }
            result = result * 10 + curNumber;
        }
        return positive ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1453236469));
    }
}
