package org.my.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class BSTSearchTest {

    @Test
    public void shouldSearch() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);

        assertNull(BSTSearchUtils.search(root, 34));
        assertEquals(155, BSTSearchUtils.search(root, 155).value);
        assertEquals(345, BSTSearchUtils.search(root, 345).value);
    }

    @Test
    public void shouldEqualSame() {
        
        Node root1 = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root1, 155);
        BinaryTree.addNode(root1, 345);
        Node root2 = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root2, 155);
        BinaryTree.addNode(root2, 345);
        assertTrue(BSTSearchUtils.sameTree(root1, root2));

        BinaryTree.addNode(root2, 345);
        assertFalse(BSTSearchUtils.sameTree(root1, root2));
    }

    @Test
    public void shouldCalculateHeight() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        assertEquals(2, BSTSearchUtils.height(root));
    }

    @Test
    public void shouldCalculateSize() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        assertEquals(3, BSTSearchUtils.size(root));
    }

    @Test
    public void shouldSearchPath() {
        List<Integer> result = new ArrayList<>();
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        assertTrue(BSTSearchUtils.rootToLeafSum(root, 410, result));
        assertArrayEquals(new Object[] {155, 255}, result.toArray());
        result = new ArrayList<>();
        assertTrue(BSTSearchUtils.rootToLeafSum(root, 600, result));
        assertArrayEquals(new Object[] {345, 255}, result.toArray());
        result = new ArrayList<>();
        assertFalse(BSTSearchUtils.rootToLeafSum(root, 601, result));
        assertArrayEquals(new Object[] {}, result.toArray());
    }

    @Test
    public void shouldCheckBST() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        assertTrue(BSTSearchUtils.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        Node l211 = new Node(5, null, null);
        Node l212 = new Node(10, null, null);
        Node l11 = new Node(0, l211, l212);
        root = new Node(1, l11, null);
        assertFalse(BSTSearchUtils.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void shouldBreadthFirstTraversal() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        BinaryTree.addNode(root, 110);
        BinaryTree.addNode(root, 160);
        BinaryTree.addNode(root, 260);
        BinaryTree.addNode(root, 360);
        assertArrayEquals(new Object[] {255, 155, 345, 110, 160, 260, 360}, BSTSearchUtils.breadthFirstTraversal(root).toArray());

    }
}