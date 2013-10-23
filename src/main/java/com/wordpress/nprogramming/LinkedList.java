package com.wordpress.nprogramming;

public interface LinkedList<E> {
    void add(E item);

    E removeFirst();
    E remove(int index);

    E getFirst();
    E getLast();
    E get(int index);

    void set(int index, E item);

    boolean isEmpty();
    int size();
    void clear();
}
