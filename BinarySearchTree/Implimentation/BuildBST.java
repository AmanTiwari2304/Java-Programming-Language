package BinarySearchTree.Implimentation;

import Queue.Deque.stackWithDeque;
import Recursion.recursionAdvance;

public class BuildBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
    }
    public static Node insert(Node root, int val){
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        if (root.data < val) {
            root.right = insert(root.right, val);
        }
        return root;

    }

    public static boolean searchInBST(Node root, int key){
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return searchInBST(root.left, key);
        }else{
            return searchInBST(root.right, key);
        }
        
    }

    public static Node findInOrderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int val){
        if (root == null) {
            return null; // Handle null root
        }
        if (root.data < val) {
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{// voila case
            // case 1 - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 - one child
            if (root.left == null ) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            } 

            // case 3 - two children
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;// Replace current node's value with in-order successor's value
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node printInRange(Node root, int k1, int k2){
        if (root == null) {
            return null;
        }
        if(k1 <= root.data && k2 >= root.data){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if (k1 <= root.data) {
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
        return root;
    }

    public static void inorder(Node root){
        if (root == null) {
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        // System.out.println(searchInBST(root, 3));

        // delete(root, 1);
        // System.out.println();
        // inorder(root);

        System.out.println();
        printInRange(root, 5, 12);
        
    }
}
