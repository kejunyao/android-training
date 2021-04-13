package com.kejunyao.base;

/**
 * 树结点
 *
 * @author kejunyao
 * @since 2021年03月04日
 */
public class TreeNode<E> {
    /** 父节点 */
    public DoubleNode<E> parent;
    /** 元素值 */
    public E element;
    /** 左子树 */
    public DoubleNode<E> left;
    /** 右子树 */
    public DoubleNode<E> right;
}
