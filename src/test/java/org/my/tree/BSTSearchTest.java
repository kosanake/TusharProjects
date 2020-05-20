package org.my.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    @Test
    public void shouldPostOrderTraversal() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        BinaryTree.addNode(root, 110);
        BinaryTree.addNode(root, 160);
        BinaryTree.addNode(root, 260);
        BinaryTree.addNode(root, 360);
        Stack<Integer> integers = BSTSearchUtils.postOrderDepthTraversal(root);
        List<Integer> integerList = new ArrayList<>();
        while (!integers.isEmpty())
            integerList.add(integers.pop());
        assertArrayEquals(integerList.toArray(), new Object[]{110, 160, 155, 260, 360, 345, 255});
    }

    @Test
    public void shouldPreOrderTraversal() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        BinaryTree.addNode(root, 110);
        BinaryTree.addNode(root, 160);
        BinaryTree.addNode(root, 260);
        BinaryTree.addNode(root, 360);
        List<Integer> integerList = BSTSearchUtils.preOrderDepthTraversal(root);
        assertArrayEquals(integerList.toArray(), new Object[]{255, 155, 110, 160, 345, 260, 360});
    }

    @Test
    public void shouldInOrderTraversal() {
        Node root = BinaryTree.addNode(null, 255);
        BinaryTree.addNode(root, 155);
        BinaryTree.addNode(root, 345);
        BinaryTree.addNode(root, 110);
        BinaryTree.addNode(root, 160);
        BinaryTree.addNode(root, 260);
        BinaryTree.addNode(root, 360);
        List<Integer> integerList = BSTSearchUtils.inOrderDepthTraversal(root);
        assertArrayEquals(integerList.toArray(), new Object[]{110, 155, 160, 255, 260, 345, 360});
    }
}