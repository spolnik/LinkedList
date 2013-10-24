package com.wordpress.nprogramming;

public interface LinkedList<E> {
    void add(E value);

    E removeFirst();
    E remove(int index);

    E getFirst();
    E getLast();
    E get(int index);

    void set(int index, E value);

    boolean isEmpty();
    int size();
    void clear();
}
