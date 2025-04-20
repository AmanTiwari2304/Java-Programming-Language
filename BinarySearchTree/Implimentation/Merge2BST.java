package BinarySearchTree.Implimentation;

import java.util.ArrayList;

import Recursion.recursionAdvance;

public class Merge2BST {
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
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right); 
    }

    public static void getInorder(Node root, ArrayList<Integer> arr){
        if (root == null) {
            return;
        }

        getInorder(root.left,arr);
        arr.add(root.data);
        getInorder(root.right,arr);

    }

    public static Node createBalancedBST(ArrayList<Integer> finalArr , int st, int end){
        if (st > end) {
            return null;
        }

        int mid = (st+end)/2;
        Node root  = new Node(finalArr.get(mid));
        root.left = createBalancedBST(finalArr, st, mid-1);
        root.right = createBalancedBST(finalArr, mid+1, end);

        return root;
    }

    public static Node mergeBSTs(Node root1, Node root2){
        // step1
        ArrayList<Integer> firstArr = new ArrayList<>();
        getInorder(root1, firstArr);

        // step2
        ArrayList<Integer> secArr = new ArrayList<>();
        getInorder(root2, secArr);

        // step3 merge
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i<firstArr.size() && j<secArr.size()) {
            if (firstArr.get(i) <= secArr.get(j)) {
                finalArr.add(firstArr.get(i));
                i++;
            }else{
                finalArr.add(secArr.get(j));
                j++;
            }
        }

        while (i<firstArr.size()) {
            finalArr.add(firstArr.get(i));
            i++;
        }

        while (j<secArr.size()) {
            finalArr.add(secArr.get(j));
            j++;
        }

        // step4 sorted AL -> createBalanced BST
        int st = 0;
        int end = finalArr.size()-1;
        return createBalancedBST(finalArr, st, end);

    }

    public static void main(String[] args) {
        int firstBST[] = {2, 1, 4};
        int secBST[] = {9, 3, 12};
        Node root1 = null;
        Node root2 = null;

        for (int i = 0; i < firstBST.length; i++) {
            root1 = insert(root1, firstBST[i]);
        }
        
        for (int i = 0; i < secBST.length; i++) {
            root2 = insert(root2, secBST[i]);
        } 

        Node root = mergeBSTs(root1, root2);
        preorder(root);



    }
}
