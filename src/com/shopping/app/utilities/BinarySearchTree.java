package com.shopping.app.utilities;

import java.util.ArrayList;

public class BinarySearchTree<T> extends BinaryTreeArrayBase<T> {
    private TreeNode<T> leftTree;
    private TreeNode<T> rightTree;
    public BinarySearchTree() {
        super();
    }

    @Override
    public BinaryTree<T> createBinaryTree() {
        return null;
    }

    @Override
    public BinaryTree<T> createBinaryTree(T rootItem) {
        return null;
    }

    @Override
    public void setRootItem(T newItem) {
        throw new UnsupportedOperationException("Not supported by this Binary Tree." );

    }
}
