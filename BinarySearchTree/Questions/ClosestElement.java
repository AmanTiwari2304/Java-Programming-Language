package BinarySearchTree.Questions;

public class ClosestElement {
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
    public static int minDifference = Integer.MAX_VALUE;
    public static int closestRoot = 0;
    public static int closestElementInBST(Node root, int K){
        if (root == null) {
            return closestRoot;
        }

        int currVal = Math.abs(K-root.data);
        if (minDifference > currVal) {
            minDifference = currVal;
            closestRoot = root.data;
        }
        if (K<root.data) {
            closestElementInBST(root.left, K);  
        }else{
            closestElementInBST(root.right, K);
        }

        return closestRoot;
    }
    
    public static void main(String[] args) {
        int values[] = {8, 5, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < values.length; i++) {
           root = insert(root, values[i]);
        } 

        System.out.println(closestElementInBST(root, 13));
    }
}
