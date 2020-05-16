package org.my.tree;

public class BinaryTree {

    public static Node addNode(Node root, int value) {
        Node node = new Node(value, null, null);
        if (root == null)
            return node;

        Node prevNode = root;
        Node current = root;
        while (prevNode != null) {
            current = prevNode;
            if (value < current.value) {
                prevNode = prevNode.left;
            } else {
                prevNode = prevNode.right;
            }
        }

        if (value < current.value) {
            current.left = node;
        } else {
            current.right = node;
        }

        return root;
    }
}
