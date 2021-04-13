package com.kejunyao.base;

import android.util.Log;

/**
 * 通用工具类
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

    public static <E> String toString(SingleNode<E> node) {
        if (node == null || node.element == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append(node.element);
        SingleNode<?> current = node.next;
        while (current != null) {
            sb.append(", ").append(current.element);
            current = current.next;
        }
        return sb.toString();
    }

    public static String toString(DoubleNode<?> node) {
        if (node == null || node.element == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append(node.element);
        DoubleNode<?> current = node.next;
        while (current != null) {
            sb.append(", ").append(current.element);
            current = current.next;
        }
        return sb.toString();
    }

    public static <E> void add(SingleNode<E> node, E e) {
        if (node == null) {
            node = new SingleNode<>();
            node.element = e;
        } else {
            SingleNode<E> next = node;
            while (true) {
                if (next.next == null) {
                    break;
                }
                next = next.next;
            }
            SingleNode<E> singleNode = new SingleNode<>();
            singleNode.element = e;
            next.next = singleNode;
        }
    }

    public static <E> void add(DoubleNode<E> node, E e) {
        if (node == null) {
            node = new DoubleNode<>();
            node.element = e;
        } else {
            DoubleNode<E> next = node;
            while (true) {
                if (next.next == null) {
                    break;
                }
                next = next.next;
            }
            DoubleNode<E> doubleNode = new DoubleNode<>();
            doubleNode.element = e;
            next.next = doubleNode;
            doubleNode.prev = next;
        }
    }

    public static void log(String tag, Object...args) {
        if (args == null || args.length == 0) {
            return;
        }
        if (args.length == 1) {
            Object obj = args[0];
            if (obj != null) {
                Log.d(tag, obj.toString());
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : args) {
            sb.append(obj.toString());
        }
        Log.d(tag, sb.toString());
    }
}
