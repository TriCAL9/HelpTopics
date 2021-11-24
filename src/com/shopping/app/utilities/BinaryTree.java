package com.shopping.app.utilities;

import com.shopping.app.utilities.adt.exceptions.TreeException;

import java.util.ArrayList;

public class BinaryTree<T> extends BinaryTreeArrayBase<T> {
    public BinaryTree(T rootItem, BinaryTree<T> leftSubTree, BinaryTree<T> rightSubtree) {
        setRootItem(rootItem);
        attachLeftSubtree(leftSubTree);
        attachRightSubtree(rightSubtree);
    }

    public BinaryTree(T rootItem) {
        super();
        var initialTreeNode = new TreeNode<T>();
        initialTreeNode.setItem(rootItem);
        tree.add(initialTreeNode);
        root+=1;
    }

    public BinaryTree() {
        super();
    }

    protected BinaryTree(TreeNode<T> rootNode){
        super(rootNode);
    }

    @Override
    public BinaryTree<T> createBinaryTree() {
        return new BinaryTree<>();
    }

    @Override
    public BinaryTree<T> createBinaryTree(T rootItem) {
        return new BinaryTree<T>(rootItem);
    }

    public  BinaryTree<T> createBinaryTree(T rootItem, BinaryTree<T> leftBinaryTree, BinaryTree<T> rightBinaryTree) {
        return new BinaryTree<T>(rootItem, leftBinaryTree, rightBinaryTree);
    }

    @Override
    public void setRootItem(T newItem){
        if (getRootItem() != null) {
            tree.get(tree.indexOf(getRootItem())).setItem(newItem);
        } else {
            var initialTreeNode = new TreeNode<T>();
            initialTreeNode.setItem(newItem);
            tree.add(initialTreeNode);
            root+=1;
        }
    }

    public void attachLeftSubtree(BinaryTree<T> leftTree) throws TreeException{
        if(isEmpty()) {
           throw new TreeException("TreeException: Empty tree");
        } else if (tree.get(root).getLeftChild() != -1) {
            throw new TreeException("TreeException: Cannot overwrite left subtree");
        } else{
            tree.add(free, leftTree.tree.get(leftTree.root));
            free = tree.get(free).getRightChild();;
            leftTree.makeEmpty();
        }
    }

    public void attachRightSubtree(BinaryTree<T> rightTree) throws TreeException{
        if(isEmpty()) {
            throw new TreeException("TreeException: Empty tree");
        }else if (tree.get(root).getRightChild() != -1) {
            throw new TreeException("TreeException: Cannot overwrite right subtree");
        }else {
            tree.add(free, rightTree.tree.get(rightTree.root));
            free = tree.get(free).getRightChild();
            rightTree.makeEmpty();
        }
    }

    public void attachLeft(T newItem) {
        if(!isEmpty() && tree.get(free).getItem() == null) {
            tree.add(free, new TreeNode<>(newItem, -1, -1));
            free = tree.get(free).getRightChild();
        } else {
            throw new TreeException("TreeException: Can't overwrite  tree");
        }
    }
    public void attachRight(T newItem) {
        if(!isEmpty() && tree.get(free).getItem() == null) {
            tree.add(free, new TreeNode<>(newItem, -1, -1));
            free = tree.get(free).getRightChild();
        }
    }

    BinaryTree<T> detachLeftSubtree() throws TreeException {
        if(isEmpty()) {
            throw new TreeException("TreeException: Tree is empty");
        } else {
            BinaryTree<T> leftTree;
            leftTree = new BinaryTree<T>(tree.get(tree.get(root).getLeftChild()));
            return leftTree;
        }
    }
    BinaryTree<T> detachRightSubtree() throws TreeException {
        return null;
    }
}
