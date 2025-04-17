package BinaryTree.Assignment;

import BinaryTree.Assignment.CheckBinary.BinaryTree;
import Queue.Deque.stackWithDeque;

public class CheckBinary {
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

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx ++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static boolean isUnivalued(Node root){
            if (root == null) {
                return true;
            }

            // check
            if ( root.left != null && root.data != root.left.data) {
                return false;
            }

            if (root.right != null && root.data != root.right.data) {
                return false;
            }


            return isUnivalued(root.left) && isUnivalued(root.right);

        }

        public static Node mirrorImage(Node root){
            if (root == null) {
                return root;
            }

            Node left = mirrorImage(root.left);
            Node right = mirrorImage(root.right);

            root.left = right;
            root.right = left;

            return root;
        }

        public static Node deleteLeafNodes(Node root, int x){
            if (root == null) {
                return root;
            }
            root.left = deleteLeafNodes(root.left, x);
            root.right =  deleteLeafNodes(root.right, x);

            if (root.data == x ) {
                if (root.left == null && root.right == null) {
                    root = null;
                    root = null;
                }
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

    }

    public static void main(String[] args) {
        // int nodes[] = {2, 2,  2, -1, -1, 2, -1, -1, 2, -1, 2, -1, -1};
        // int nodes[] = {1, 2,  4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int nodes[] = {1, 3,  3, -1, -1, 2, -1, -1, 3, -1, -1, };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // if (BinaryTree.isUnivalued(root)) {
        //     System.out.println("Yes it is uniequaled");
        // }else{
        //     System.out.println("No it is not");
        // }

        // tree.preorder(root);
        // System.out.println();
        // tree.mirrorImage(root);
        // tree.preorder(root);

        // tree.preorder(root);
        // System.out.println();
        // int x = 3;
        // tree.deleteLeafNodes(root,x);
        // tree.preorder(root);
    }
}
