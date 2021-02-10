package com.kejunyao.algorithm;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年01月30日
 */
public class Node<T> {
    T data;
    Node<T> next;

    @Override
    public String toString() {
        return data == null ? "" : data.toString();
    }
}
