package com.wordpress.nprogramming;

public class DoubleNode<E> {
    private DoubleNode<E> next;
    private DoubleNode<E> previous;
    private E data;

    public DoubleNode(E data) {
        this.data = data;
    }

    public void appendToTail(E data) {
        DoubleNode<E> end = new DoubleNode<>(data);

        DoubleNode<E> current = this;
        while (current.next != null) {
            current = current.next;
        }

        current.next = end;
        end.previous = current;
    }

    public DoubleNode<E> deleteNode(E data) {
        DoubleNode<E> head = this;

        if (head.data == data) {
            if (head.next != null) {
                head.next.previous = null;
            }
            return head.next;
        }

        DoubleNode<E> current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                current.next.previous = current;
                return head;
            }

            current = current.next;
        }

        return head;
    }

    public DoubleNode<E> getNext() {
        return next;
    }

    public DoubleNode<E> getPrevious() {
        return previous;
    }

    public E getData() {
        return data;
    }
}
