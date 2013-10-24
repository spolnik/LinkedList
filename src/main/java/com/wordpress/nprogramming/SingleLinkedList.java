package com.wordpress.nprogramming;

public final class SingleLinkedList<E> implements LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    public SingleLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void add(E item) {
        if (head == null) {
            head = new Node<>(item);
            tail = head;
            return;
        }

        Node<E> previous = tail;
        tail = new Node<>(item);
        previous.next = tail;
    }

    @Override
    public E removeFirst() {
        checkIfListIsNotEmpty();

        Node<E> deletedNode = head;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return deletedNode.value;
    }

    @Override
    public E remove(int index) {
        checkIfIndexValid(index);

        if (index == 0) {
            return removeFirst();
        } else {
            int count = 1;
            Node<E> current = head.next;
            Node<E> previous = head;

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
        checkIfListIsNotEmpty();
        return head.value;
    }

    @Override
    public E getLast() {
        checkIfListIsNotEmpty();
        return tail.value;
    }

    @Override
    public E get(int index) {
        checkIfIndexValid(index);

        int count = 0;
        Node<E> node = head;

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
        checkIfIndexValid(index);

        int count = 0;
        Node<E> node = head;

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
        return head == null;
    }

    @Override
    public int size() {
        Node<E> node = head;
        int count = 0;

        while (node != null) {
            node = node.next;
            count++;
        }

        return count;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    private void checkIfListIsNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }
    }

    private void checkIfIndexValid(int index) {
        if (index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
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
