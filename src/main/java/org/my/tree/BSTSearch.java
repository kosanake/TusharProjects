package org.my.tree;

public class BSTSearch {
    public static Node search(Node node, int value) {
        if (node == null) {
            return null;
        } else if (node.value == value) {
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }
}