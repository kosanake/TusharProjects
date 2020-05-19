package org.my.tree;

import java.util.*;

public class BSTSearchUtils {
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

    public static int height(Node root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        return  1 + Math.max(left, right);
    }

    public static int size(Node node) {
        if (node == null)
            return 0;
        int left = size(node.left);
        int right = size(node.right);
        return left + right + 1;
    }

    public static boolean rootToLeafSum(Node node, int sum, List<Integer> result) {
        if (node == null) {
            return false;
        } else if (node.left == null && node.right == null) {
            if (sum - node.value == 0) {
                result.add(node.value);
                return true;
            }
        }
        if(rootToLeafSum(node.left, sum - node.value, result)) {
            result.add(node.value);
            return true;
        }
        if (rootToLeafSum(node.right, sum - node.value, result)) {
            result.add(node.value);
            return true;
        }
        return false;
    }

    public static boolean isBST(Node node, int min, int max) {
        if (node == null)
            return true;
        if (node.value < min || node.value > max)
            return false;
        return isBST(node.left, Integer.MIN_VALUE, node.value) && isBST(node.right, node.value, Integer.MAX_VALUE);
    }

    public static List<Integer> breadthFirstTraversal(Node node) {
        List<Integer> result = new ArrayList<>();
        if (node == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            result.add(poll.value);
            if (poll.left != null)
                queue.add(poll.left);
            if (poll.right != null)
                queue.add(poll.right);
        }

        return result;
    }
}