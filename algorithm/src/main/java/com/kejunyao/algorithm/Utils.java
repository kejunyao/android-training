package com.kejunyao.algorithm;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年02月11日
 */
public final class Utils {

    private Utils() {
    }

    public static String toString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, size = array.length; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
