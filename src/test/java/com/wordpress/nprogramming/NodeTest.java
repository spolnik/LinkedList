package com.wordpress.nprogramming;

import static junit.framework.Assert.*;
import org.junit.Test;

public class NodeTest {
    @Test
    public void testAppendToTail() throws Exception {
        Node<String> node = new Node<>("First");
        node.appendToTail("Second");

        assertEquals("First", node.getData());
        assertEquals("Second", node.getNext().getData());
    }

    @Test
    public void testDeleteNode() throws Exception {
        Node<String> node = new Node<>("First");
        node.appendToTail("Second");
        node.appendToTail("Third");

        Node<String> newNode = node.deleteNode("Second");

        assertEquals("First", newNode.getData());
        assertEquals("Third", newNode.getNext().getData());
    }

    @Test
    public void testDeleteAllNodes() throws Exception {
        Node<String> node = new Node<>("First");
        node.appendToTail("Second");

        Node<String> nodeWithOneElement = node.deleteNode("First");
        Node<String> nodeWithoutElements = nodeWithOneElement.deleteNode("Second");

        assertTrue(nodeWithoutElements == null);
    }

    @Test
    public void testDeletingNonExistingItem() throws Exception {
        Node<String> node = new Node<>("First");
        node.appendToTail("Second");

        Node<String> newNode = node.deleteNode("Non-existing-item");

        assertEquals("First", newNode.getData());
        assertEquals("Second", newNode.getNext().getData());

    }
}
