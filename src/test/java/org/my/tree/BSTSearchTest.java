package org.my.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BSTSearchTest {

    @Test
    public void search() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);

        assertNull(BSTSearch.search(root, 34));
        assertEquals(155, BSTSearch.search(root, 155).value);
        assertEquals(345, BSTSearch.search(root, 345).value);
    }
}