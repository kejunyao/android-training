package com.kejunyao.algorithm;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 给你⼀个链表，每 k 个节点⼀组进⾏翻转，请你返回翻转后的链表。
 * k 是⼀个正整数，它的值⼩于或等于链表的⻓度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回：2->1->4->3->5
 * 当 k = 3 时，应当返回：3->2->1->4->5
 *
 * @author kejunyao
 * @since 2021年01月30日
 */
public class LinkListReverse<E> {

    private Node<E> head;
    private int size = 0;

    public LinkListReverse() {
        // ConcurrentHashMap
        //HashMap
    }

    public int getSize() {
        return size;
    }

    public int add(E e) {
        if (head == null) {
            head = new Node<>();
            head.data = e;
            size = 1;
            return 0;
        }
        Node<E> last = head;
        int index = 0;
        while (true) {
            Node<E> l = last.next;
            if (l == null) {
                break;
            }
            index += 1;
            last = l;
        }
        Node<E> node = new Node<>();
        node.data = e;
        node.next = null;
        last.next = node;
        index += 1;
        size = index + 1;
        return index;
    }

    public E get(int index) {
        if (head == null) {
            return null;
        }
        int tmpIndex = -1;
        Node<E> next = head;
        while (next != null) {
            tmpIndex += 1;
            if (index == tmpIndex) {
                return next.data;
            }
            next = next.next;
        }
        return null;
    }

    /**
     * 多少一组进行旋转
     * @param node 头结点
     */
    private Node<E> reverse(Node<E> node) {
        Node<E> prev = null;
        Node<E> curr = node;
        Node<E> next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private Node<E> reverse(Node<E> a, Node<E> b) {
        Node<E> prev = null;
        Node<E> curr = a;
        Node<E> next = a;
        while (curr != b) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private Node<E> reverseKGroup(Node<E> node, int k) {
        if (node == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        Node<E> a, b;
        a = b = node;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return node;
            b = b.next;
        }
        // 反转前 k 个元素
        Node<E>  newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public static String main() {
        LinkListReverse<Integer> list = new LinkListReverse<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // list.head = list.reverseKGroup(list.head, 3);
        list.head = list.reverse(list.head);

        StringBuilder sb = new StringBuilder();
        for (int i = 0, size = list.getSize(); i < size; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
