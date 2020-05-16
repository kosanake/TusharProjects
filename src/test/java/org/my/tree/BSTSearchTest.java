package org.my.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTSearchTest {

    @Test
    public void shouldSearch() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);

        assertNull(BSTSearch.search(root, 34));
        assertEquals(155, BSTSearch.search(root, 155).value);
        assertEquals(345, BSTSearch.search(root, 345).value);
    }

    @Test
    public void shouldEqualSame() {
        
        Node root1 = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root1, 155);
        BinaryTree.addNode(root1, 345);
        Node root2 = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root2, 155);
        BinaryTree.addNode(root2, 345);
        assertTrue(BSTSearch.sameTree(root1, root2));

        BinaryTree.addNode(root2, 345);
        assertFalse(BSTSearch.sameTree(root1, root2));
    }
}