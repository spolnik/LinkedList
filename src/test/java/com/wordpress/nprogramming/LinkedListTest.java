package com.wordpress.nprogramming;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class LinkedListTest {

    private LinkedList<String> list;
    private final static String first = "First";
    private final static String second = "Second";

    @Before
    public void setUp() {
        list = new SingleLinkedList<>();
        list.add(first);
        list.add(second);
    }

    @Test
    public void testAddAndGetFirst() throws Exception {
        assertEquals(first, list.getFirst());
    }

    @Test
    public void testAddAndGetLast() throws Exception {
        assertEquals(second, list.getLast());
    }

    @Test
    public void testAddAndGetByIndex() throws Exception {
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
    }

    @Test
    public void testRemoveFirst() throws Exception {
        String actual = list.removeFirst();

        assertEquals(first, actual);
    }

    @Test
    public void testRemove() throws Exception {
        String actual = list.remove(1);

        assertEquals(second, actual);

        list.remove(0);

        assertTrue(list.isEmpty());
    }

    @Test
    public void testSetValue() throws Exception {
        String item = "Third";

        list.set(1, item);

        assertEquals(item, list.get(1));
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertFalse(list.isEmpty());

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(2, list.size());
    }

    @Test
    public void addItemsThenRemoveThenAddAgain() throws Exception {
        list.add("Third");

        assertEquals(3, list.size());
        assertEquals("First", list.getFirst());
        assertEquals("Third", list.getLast());

        list.remove(0);

        assertEquals(2, list.size());
        assertEquals("Second", list.getFirst());
        assertEquals("Third", list.getLast());

        list.clear();

        assertTrue(list.isEmpty());

        list.add("Third");

        assertEquals(1, list.size());
        assertEquals("Third", list.getFirst());
        assertEquals("Third", list.getLast());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetFirstWhenEmpty() throws Exception {
        list.clear();
        list.getFirst();
    }

    @Test(expected = IllegalStateException.class)
    public void testGetLastWhenEmpty() throws Exception {
        list.clear();
        list.getLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfIndex() throws Exception {
        list.remove(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfIndex() throws Exception {
        list.get(3);
    }
}
