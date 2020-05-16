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

    public static boolean sameTree(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null)
            return true;
        if (tree1 == null || tree2 == null)
            return false;
        return tree1.value == tree2.value && sameTree(tree1.left, tree2.left) && sameTree(tree1.right, tree2.right);
    }
}