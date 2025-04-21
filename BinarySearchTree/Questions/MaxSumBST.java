package BinarySearchTree.Questions;

public class MaxSumBST {
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
    public static boolean isBST(Node root){
        if (root == null) {
            return true;
        }

        if ((root.left != null && root.left.data > root.data)
            || (root.right != null && root.right.data < root.data)) {
            return false;
        } 

        return isBST(root.left)
                && isBST(root.right) ;
    }
    public static int maxSum = Integer.MIN_VALUE;
    public static int maxSumBstInBinaryTree(Node root){
        if (root == null) {
            return 0 ;
        }

        int leftSum = maxSumBstInBinaryTree(root.left);
        int rightSum = maxSumBstInBinaryTree(root.right);

        if (isBST(root)) {
            int totalSum  = root.data + leftSum + rightSum;
            maxSum = Math.max(maxSum, totalSum);
            
        }

        return maxSum;


    }
    

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.left.left = new Node(6);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);
        
        root.right = new Node(2);
        root.right.right = new Node(3);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80); 

        System.out.println(maxSumBstInBinaryTree(root));
    }
}
