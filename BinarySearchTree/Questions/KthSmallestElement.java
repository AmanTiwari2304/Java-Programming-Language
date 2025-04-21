package BinarySearchTree.Questions;

import java.util.ArrayList;

import Queue.Deque.stackWithDeque;

public class KthSmallestElement {
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

    public static void getInorder(Node root, ArrayList<Integer> arr){
        if (root == null) {
            return ;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);

        
    }

    public static void kThSmallestEleInBST(Node root, int K){
        ArrayList<Integer> arr = new ArrayList<>();
        getInorder(root, arr);

        for (int i = 0; i < arr.size(); i++) {
            if (i==K-1) {
                System.out.println(arr.get(i));
            }
        }
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < values.length; i++) {
           root = insert(root, values[i]);
        } 

        kThSmallestEleInBST(root, 7);
    }
}
