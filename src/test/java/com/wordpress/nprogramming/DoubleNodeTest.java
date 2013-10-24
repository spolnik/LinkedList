package com.wordpress.nprogramming;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class DoubleNodeTest {
    @Test
    public void testAppendToTail() throws Exception {
        DoubleNode<String> node = new DoubleNode<>("First");
        node.appendToTail("Second");

        assertEquals("First", node.getData());
        assertEquals("Second", node.getNext().getData());
        assertEquals("First", node.getNext().getPrevious().getData());
    }

    @Test
    public void testNextIsNullForOneItemList() throws Exception {
        DoubleNode<String> node = new DoubleNode<>("First");
        assertEquals(null, node.getNext());
    }

    @Test
    public void testPreviousIsNullForOneItemList() throws Exception {
        DoubleNode<String> node = new DoubleNode<>("First");
        assertEquals(null, node.getPrevious());
    }

    @Test
    public void testDeleteDoubleNode() throws Exception {
        DoubleNode<String> node = new DoubleNode<>("First");
        node.appendToTail("Second");
        node.appendToTail("Third");

        DoubleNode<String> newDoubleNode = node.deleteNode("Second");

        assertEquals("First", newDoubleNode.getData());
        assertEquals("Third", newDoubleNode.getNext().getData());
    }

    @Test
    public void testDeleteAllDoubleNodes() throws Exception {
        DoubleNode<String> node = new DoubleNode<>("First");
        node.appendToTail("Second");

        DoubleNode<String> nodeWithOneElement = node.deleteNode("First");
        DoubleNode<String> nodeWithoutElements = nodeWithOneElement.deleteNode("Second");

        assertTrue(nodeWithoutElements == null);
    }

    @Test
    public void testDeletingNonExistingItem() throws Exception {
        DoubleNode<String> node = new DoubleNode<>("First");
        node.appendToTail("Second");

        DoubleNode<String> newDoubleNode = node.deleteNode("Non-existing-item");

        assertEquals("First", newDoubleNode.getData());
        assertEquals("Second", newDoubleNode.getNext().getData());

    }
}
