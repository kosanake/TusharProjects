package org.my.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BSTSearchTest {

    @Test
    public void search() {
        Node left = new Node(155, null, null);
        Node right = new Node(345, null, null);
        Node root = new Node(255, left, right);

        assertNull(BSTSearch.search(root, 34));
        assertEquals(left, BSTSearch.search(root, 155));
        assertEquals(right, BSTSearch.search(root, 345));
    }
}