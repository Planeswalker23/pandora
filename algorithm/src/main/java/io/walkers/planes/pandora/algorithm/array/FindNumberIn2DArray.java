package io.walkers.planes.pandora.algorithm.array;

/**
 * <a href="https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/">
 * 剑指 Offer 04. 二维数组中的查找
 * </a>
 *
 * @author planeswalker23
 * @date 2022/1/16
 */
public class FindNumberIn2DArray {

    public static void main(String[] args) {
        FindNumberIn2DArray demo = new FindNumberIn2DArray();
        int[][] array = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean result = demo.findNumberIn2DArray(array, 5);
        System.out.println(result);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length, row = 0, col = cols - 1;
        if (matrix[0][0] > target || matrix[rows - 1][cols - 1] < target) {
            return false;
        }
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
