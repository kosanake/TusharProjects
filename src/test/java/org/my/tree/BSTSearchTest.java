package org.my.tree;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void shouldCalculateHeight() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        assertEquals(2, BSTSearch.height(root));
    }

    @Test
    public void shouldCalculateSize() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        assertEquals(3, BSTSearch.size(root));
    }

    @Test
    public void shouldSearchPath() {
        List<Integer> result = new ArrayList<>();
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        assertTrue(BSTSearch.rootToLeafSum(root, 410, result));
        assertArrayEquals(new Object[] {155, 255}, result.toArray());
        result = new ArrayList<>();
        assertTrue(BSTSearch.rootToLeafSum(root, 600, result));
        assertArrayEquals(new Object[] {345, 255}, result.toArray());
        result = new ArrayList<>();
        assertFalse(BSTSearch.rootToLeafSum(root, 601, result));
        assertArrayEquals(new Object[] {}, result.toArray());
    }

    @Test
    public void shouldCheckBST() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        assertTrue(BSTSearch.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        Node l211 = new Node(5, null, null);
        Node l212 = new Node(10, null, null);
        Node l11 = new Node(0, l211, l212);
        root = new Node(1, l11, null);
        assertFalse(BSTSearch.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}