package com.kejunyao.base;

/**
 * 双链表结点
 *
 * @author kejunyao
 * @since 2021年03月04日
 */
public class DoubleNode<E> {
    /** 元素值 */
    public E element;
    /** 前驱 */
    public DoubleNode<E> prev;
    /** 后继 */
    public DoubleNode<E> next;
}
