package com.shopping.app.utilities;

import com.shopping.app.utilities.adt.QueueArrayBased;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator<T> implements Iterator<T> {
    private BinaryTreeArrayBase<T> binTree;
    TreeNode<T> currentNode;
    QueueArrayBased<TreeNode<T>> queue;

    public TreeIterator(BinaryTreeArrayBase<T> aBTree) {
        this.binTree = aBTree;
        currentNode = null;
        queue = new QueueArrayBased<>();
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return queue.isEmpty();
    }

    @Override
    public T next() throws NoSuchElementException {
        currentNode = queue.dequeue();
        return currentNode.getItem();
    }

    public void setPreorder() {
        queue.dequeue();
        preorder(binTree.tree.get(binTree.root));
    }

    public void setInorder() {
        queue.dequeue();
        inorder(binTree.tree.get(binTree.root));
    }

    public void setPostOrder() {
        queue.dequeue();
        postorder(binTree.tree.get(binTree.root));
    }

    public void preorder(TreeNode<T> treeNode) {
        if (treeNode != null) {
            queue.enqueue(treeNode);
            preorder(binTree.tree.get(treeNode.getLeftChild()));
            preorder(binTree.tree.get(treeNode.getRightChild()));
        }
    }

    public void inorder(TreeNode<T> treeNode) {
        inorder(binTree.tree.get(treeNode.getLeftChild()));
        queue.enqueue(treeNode);
        inorder(binTree.tree.get(treeNode.getLeftChild()));
    }

    public void postorder(TreeNode<T> treeNode) {
        postorder(binTree.tree.get(treeNode.getLeftChild()));
        postorder(binTree.tree.get(treeNode.getRightChild()));
        queue.enqueue(treeNode);
    }
}
