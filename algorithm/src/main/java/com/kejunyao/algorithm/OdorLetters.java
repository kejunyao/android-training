package com.kejunyao.algorithm;

import java.util.Arrays;

/**
 * 给定两个字符串s和t，编写一个函数来判断是否是s的字母异位词。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * @author kejunyao
 * @since 2021年01月30日
 */
public class OdorLetters {

    public static boolean isAnagram(String s, String t) {
        final int length = s.length();
        if (length != t.length()) {
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        for (int i = 0; i < length; i++) {
            if (sa[i] != ta[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        int length = s.length();
        if (length != t.length()) {
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        char[] array = new char[26];
        for (char c : sa) {
            array[c - 'a'] ++;
        }
        for (char c : ta) {
            array[c - 'a'] --;
        }
        for (char c : array) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static String main() {
        String s = "anagram";
        String t = "nagaram";

        StringBuilder sb = new StringBuilder()
                .append(s).append(" and ").append(t)
                .append(" isAnagram is: ").append(isAnagram(s, t))
                .append('\n')
                .append("isAnagram2 is: ").append(isAnagram2(s, t))
                .append('\n');

        s = "rat";
        t = "car";
        sb.append(s).append(" and ").append(t)
                .append(" isAnagram is: ").append(isAnagram(s, t))
                .append('\n')
                .append(" isAnagram2 is: ").append(isAnagram2(s, t));

        return sb.toString();
    }


}
