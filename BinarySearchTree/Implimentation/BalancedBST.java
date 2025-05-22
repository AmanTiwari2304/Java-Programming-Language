package BinarySearchTree.Implimentation;

import java.util.ArrayList;

public class BalancedBST {
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

    public static void preorder(Node root){
        if (root == null) {
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void getInorder(Node root, ArrayList<Integer> inorderArr){
        if(root == null) {
            return;
        }
        getInorder(root.left,inorderArr);
        inorderArr.add(root.data);
        getInorder(root.right,inorderArr);
    }

    public static Node createBalancedBST(ArrayList<Integer> inorderArr, int st, int end){
        if (st > end) {
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(inorderArr.get(mid));
        root.left = createBalancedBST(inorderArr, st, mid-1);
        root.right = createBalancedBST(inorderArr, mid+1, end);

        return root;
    }

    public static Node balanceBST(Node root){
        // inorder seq
        ArrayList<Integer> inorderArr = new ArrayList<>();
        getInorder(root, inorderArr);

        // sorted inorder -> sorted arr -> balanced BST
        int st = 0;
        int end = inorderArr.size()-1; 
        root = createBalancedBST(inorderArr, st, end);
        return root;
    }

    public static void main(String[] args) {
        int values[] = {8, 6, 5, 3, 10, 11, 12, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }


        // Convert BST to Balanced BST:-
        preorder(root);
        root = balanceBST(root);
        System.out.println();
        preorder(root);
        
    }
}
