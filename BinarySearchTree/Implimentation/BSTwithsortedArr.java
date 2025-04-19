package BinarySearchTree.Implimentation;

import java.util.ArrayList;

import Queue.Deque.stackWithDeque;

public class BSTwithsortedArr {
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

    public static void preorder(Node root){
        if (root == null) {
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static Node createBalancedBST(int arr[], int st, int end){
        if (st > end) {
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, st, mid-1);
        root.right = createBalancedBST(arr, mid+1, end);

        return root;
    }

    

    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12, 14};
        

        // For Conversion of Array to Balanced BST:- 
        int st = 0; 
        int end = arr.length-1;
        preorder(createBalancedBST(arr, st, end));



        
        

    }
}
