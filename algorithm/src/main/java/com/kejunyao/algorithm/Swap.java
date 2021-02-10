package com.kejunyao.algorithm;

import android.util.Log;

/**
 * 将一个char[]进行翻转
 *
 * @author kejunyao
 * @since 2021年01月30日
 */
public class Swap {

    public static char[] swap(char[] chars) {
        int size = chars.length - 1;
        int low = 0;
        int high = size;
        while (low < high) {
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low += 1;
            high -= 1;
        }
        return chars;
    }

    public static void main() {
        char[] chars = {'1', '2', '3', '4'};
        chars = Swap.swap(chars);
        for (char c : chars) {
            Log.d(Tag.TAG, String.valueOf(c));
        }
    }
}
