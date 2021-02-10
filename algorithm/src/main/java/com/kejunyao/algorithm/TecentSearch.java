package com.kejunyao.algorithm;

/**
 * 腾讯算法题
 * 给1个升序数组，从中找出2个值m、n，使得m + n = K，要求最终返回 m * n为最大值的那一对
 *
 * @author kejunyao
 * @since 2021年02月03日
 */
public class TecentSearch {

    public static int[] findMax(int[] array, int k) {
        int[] result = new int[2];
        int lowIndex = 0;
        int highIndex = array.length - 1;
        int first = 0;
        int second = 0;
        while (lowIndex < highIndex) {
            int lowValue = array[lowIndex];
            int highValue = array[highIndex];
            int target = lowValue + highValue;
            if (k < target) {
                lowIndex += 1;
            } else if (k > target) {
                highIndex -= 1;
            } else {
                lowIndex += 1;
                highIndex -= 1;
                if (lowValue * highValue > first * second) {
                    first = lowValue;
                    second = highValue;
                }
            }
        }
        result[0] = first;
        result[1] = second;
        return result;
    }

    public static String main() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int k = 8;
        int[] result = findMax(array, k);
        return String.format("%d %d", result[0], result[1]);
    }
}
