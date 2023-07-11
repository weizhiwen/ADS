package com.shixin.tree.binary;


import com.shixin.tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalTest {
    /**
     *           二叉树结构
     *              A
     *          B       E
     *        C   D   F   G
     */
    public static BinaryTreeNode buildBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.setValue("A");
        root.setLeft(new BinaryTreeNode("B", new BinaryTreeNode("C"), new BinaryTreeNode("D")));
        root.setRight(new BinaryTreeNode("E", new BinaryTreeNode("F"), new BinaryTreeNode("G")));
        return root;
    }

    public static void traversal(BinaryTreeNode node, List<String> values, TraversalType type) {
        if (node == null) {
            return;
        }
        switch (type) {
            case PREORDER -> {
                values.add(node.getValue());
                traversal(node.getLeft(), values, type);
                traversal(node.getRight(), values, type);
            }
            case INORDER -> {
                traversal(node.getLeft(), values, type);
                values.add(node.getValue());
                traversal(node.getRight(), values, type);
            }
            case POSTORDER -> {
                traversal(node.getLeft(), values, type);
                traversal(node.getRight(), values, type);
                values.add(node.getValue());
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = buildBinaryTree();
        List<String> preOrderTraversalValues = new ArrayList<>();
        traversal(tree, preOrderTraversalValues, TraversalType.PREORDER);
        System.out.println("前序遍历: " + String.join(",", preOrderTraversalValues));

        List<String> inOrderTraversalValues = new ArrayList<>();
        traversal(tree, inOrderTraversalValues, TraversalType.INORDER);
        System.out.println("中序遍历: " + String.join(",", inOrderTraversalValues));

        List<String> postOrderTraversalValues = new ArrayList<>();
        traversal(tree, postOrderTraversalValues, TraversalType.POSTORDER);
        System.out.println("后序遍历: " + String.join(",", postOrderTraversalValues));
    }

    enum TraversalType {
        PREORDER,
        INORDER,
        POSTORDER
    }
}
