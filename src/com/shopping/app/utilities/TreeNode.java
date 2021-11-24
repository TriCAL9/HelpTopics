package com.shopping.app.utilities;

public class TreeNode<T> {
    private T item;
    private int leftChild;
    private int rightChild;

    public TreeNode(T item, int leftChild, int rightChild) {
        this.item = item;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNode() {
        item = null;
        leftChild = -1;
        rightChild = -1;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public int getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(int leftChild) {
        this.leftChild = leftChild;
    }

    public int getRightChild() {
        return rightChild;
    }

    public void setRightChild(int rightChild) {
        this.rightChild = rightChild;
    }

}
