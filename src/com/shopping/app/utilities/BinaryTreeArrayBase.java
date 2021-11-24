package com.shopping.app.utilities;

import com.shopping.app.utilities.adt.exceptions.TreeException;

import java.util.ArrayList;

public abstract class BinaryTreeArrayBase<T> {
    protected final int MAX_NUM_NODES = 100;
    protected ArrayList<TreeNode<T>> tree;
    protected ArrayList<TreeNode<T>> freeList = new ArrayList<>();
    protected int root;
    protected int free;

    public BinaryTreeArrayBase(TreeNode<T> treeNode) {
        tree = new ArrayList<>();
        freeList = new ArrayList<>();
        root = -1;
        free = 0;
        for(int i = 0; i < MAX_NUM_NODES; i++) {
            freeList.add(new TreeNode<>(null, -1, i+1));
        }
        var temp = free;
        free = freeList.get(free).getRightChild();
        var nodeItem = treeNode.getItem();
        var leftChild = treeNode.getLeftChild();
        var rightChild = treeNode.getRightChild();
        var node = freeList.get(free);
        node.setItem(nodeItem);
        node.setLeftChild(leftChild);
        node.setRightChild(rightChild);
        root = temp;
        System.out.println(free);
        tree.add(root, node);;
        freeList.add(free, node);
    }

    public BinaryTreeArrayBase() {
        this.tree = new ArrayList<>();
        root = -1;
        free = 0;
    }

    public abstract BinaryTree<T> createBinaryTree();

    public abstract BinaryTree<T> createBinaryTree(T rootItem);

    public void makeEmpty() {
        tree.clear();
        root = -1;
    }

    public boolean isEmpty() {
        return root == -1;
    }

    public T getRootItem() {
        if (root == -1) {
            throw new TreeException("Tree Exception: Empty Tree");
        } else {
            return tree.get(root).getItem();
        }
    }

    //Throws UnsupportedOperationException if operation is not supported.
    public abstract void setRootItem(T newItem);
}
