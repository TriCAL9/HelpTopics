package com.shopping.app.utilities;

import com.shopping.app.utilities.BinaryTree;
import com.shopping.app.utilities.BinaryTreeArrayBase;

public class BinaryTreeTest {
    public static void main(String[] args) {
        String[] names = { "Kamari Su", "Cal", "John"};
        BinaryTree<String> binaryTreeArrayBase = new BinaryTree(new TreeNode(names[0], -1, -1));
        binaryTreeArrayBase.attachLeft(names[1]);
        System.out.println("Empty: " + binaryTreeArrayBase.isEmpty());
        System.out.println("rootItem: " + binaryTreeArrayBase.getRootItem());
        System.out.println("Free index: " +binaryTreeArrayBase.free);
        System.out.println("root index: " +binaryTreeArrayBase.root);
        System.out.println("left child: " + binaryTreeArrayBase.tree
                .get(0).getLeftChild()
        + " right child " + binaryTreeArrayBase.tree.get(0).getRightChild());


    }
}
