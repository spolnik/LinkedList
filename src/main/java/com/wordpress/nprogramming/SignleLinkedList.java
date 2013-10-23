package com.wordpress.nprogramming;

public final class SignleLinkedList<E> implements LinkedList<E> {

    private Node<E> first;
    private Node<E> last;

    public SignleLinkedList() {
        first = null;
        last = null;
    }

    @Override
    public void add(E item) {
        if (first == null) {
            first = new Node<>(item);
            last = first;
            return;
        }

        Node<E> previous = last;
        last = new Node<>(item);
        previous.next = last;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }

        Node<E> toBeRemoved = first;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return toBeRemoved.value;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        if (first.next == null && index == 0) {
            Node<E> toBeRemoved = first;
            clear();
            return toBeRemoved.value;
        } else if (index == 0) {
            Node<E> toBeRemoved = first;
            first = first.next;
            return toBeRemoved.value;
        } else {
            int count = 1;
            Node<E> current = first.next;
            Node<E> previous = first;

            while (current != null) {
                if (count == index) {
                    Node<E> toBeRemoved = current;
                    current = current.next;
                    previous.next = current;
                    return toBeRemoved.value;
                }
                previous = current;
                current = current.next;
                count++;
            }
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public E getFirst() {
        return first.value;
    }

    @Override
    public E getLast() {
        return last.value;
    }

    @Override
    public E get(int index) {
        if (index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        Node<E> node = first;

        while (node != null) {
            if (count == index) {
                return node.value;
            }
            node = node.next;
            count++;
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public void set(int index, E item) {
        if (index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        Node<E> node = first;

        while (node != null) {
            if (count == index) {
                node.value = item;
                return;
            }
            node = node.next;
            count++;
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        Node<E> node = first;
        int count = 0;

        while (node != null) {
            node = node.next;
            count++;
        }

        return count;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    final class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            next = null;
        }
    }
}
