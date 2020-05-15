package org.my.tree;

public class BinaryTree {
    public static Node addNode(Node root, int value) {
        if (root == null)
            return new Node(value, null, null);
        Node node = root;
        Node prevNode = root;
        while (prevNode != null) {
            node = prevNode;
            if (value < prevNode.value) {
                prevNode = prevNode.left;
            } else {
                prevNode = prevNode.right;
            }
        }
        Node newNode = new Node(value, null, null);
        if (value < node.value) {
            node.left = newNode;
        } else {
            node.right = newNode;
        }
        return root;
    }
}
