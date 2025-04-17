package BinaryTree.QuestionsPart2;

import java.util.ArrayList;

import Recursion.recursionAdvance;

// Lowest Common Ancestor
public class LCA {
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

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx ++ ;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundleft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);

        if (foundright || foundleft) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        // last equal node 
        Node lca = path1.get(i-1); 
        return lca;
    }

    // Apporach 2 
    public static Node lca2(Node root, int n1, int n2){
        if (root == null || root.data == n1 || root.data == n2) {
            return root ;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        // rightLca & leftLca != null then ->
        return root;
    }

    // Minimum distance between nodes

    public static int lcaDist(Node lca, int n){
        if (lca == null) {
            return -1;
        }
        if (lca.data == n) {
            return 0;
        }

        int leftdist = lcaDist(lca.left, n);
        int rightdist = lcaDist(lca.right, n);

        if (leftdist == -1 && rightdist == -1) {
            return -1;
        }
        if (leftdist == -1) {
            return rightdist+1;
        }
        if (rightdist == -1) {
            return leftdist+1;
        }
        return leftdist+rightdist;
    }

    public static int minDistance(Node root, int n1, int n2){
        // find lca 
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;

    }

    public static int kThAncestor(Node root, int n, int k){
        if (root ==  null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDist = kThAncestor(root.left, n, k);
        int rightDist = kThAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transformToSum(Node root){
        if (root == null) {
            return 0;
        }
        int leftChild = transformToSum(root.left);
        int rightChild = transformToSum(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newright + rightChild;

        return data;
    }

    public static void preorder(Node root){
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void main(String[] args) {
        int nodes[] = {1, 2,  4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes); 
        int n1 = 2, n2 = 3;
        // System.out.println(lca(root, n1, n2).data);
        // System.out.println(lca2(root, n1, n2).data);
        // System.out.println(minDistance(root, n1, n2)); 
        // int n = 5 , k = 2;
        // kThAncestor(root, n, k);
        transformToSum(root);
        preorder(root);
    }
}
