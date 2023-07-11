package com.shixin.tree;

public class BinaryTreeNode {
    private String value;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(String value) {
        this.value = value;
    }

    public BinaryTreeNode(String value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
