package BinarySearchTree.Questions;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class RangeSumBST {
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

    

    public static int sum = 0;
    public static int rangeSumOfBST(Node root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // If the current node's value is within the range, add it to the sum
        if (root.data >= L && root.data <= R) {
            sum += root.data;
        }

        // Traverse the left subtree if the current node's value is greater than L
        if (root.data > L) {
            sum += rangeSumOfBST(root.left, L, R);
        }

        // Traverse the right subtree if the current node's value is less than R
        if (root.data < R) {
            sum += rangeSumOfBST(root.right, L, R);
        }

        return sum;
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < values.length; i++) {
           root = insert(root, values[i]);
        } 

        int L = 5, R = 11;
        System.out.println(rangeSumOfBST(root, L, R));
    }

    // some leetcode questions{
    //     Arrays.sort(preorder);
    //     int st = 0; int end = preorder.length - 1;
    //     return helper(preorder, st, end);

    // }

    // private TreeNode helper(int[] preorder, int st, int end){
    //     if(st>end) return null;
    //     int mid = (st+end)/2;
    //     TreeNode root = new TreeNode(preorder[mid]);
    //     root.left = helper(preorder, st, mid-1);
    //     root.right = helper(preorder, mid+1, end);
    //     return root;
    // }
    // }

        
}
