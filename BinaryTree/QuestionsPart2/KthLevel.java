package BinaryTree.QuestionsPart2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

import BinaryTree.QuestionsPart2.KthLevel.BinaryTree;
import Queue.Deque.stackWithDeque;

public class KthLevel {
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

        public static void findLevelOfTree(Node root, int K){
            if (root == null) {
                return;
            }
            int level = 1;

            Queue<Node> q = new LinkedList<>();
            q.add(root); //first element
            q.add(null); // after first element there will be null;

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    level++;
                    if (q.isEmpty()) {
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if (K==level) {
                        System.out.print(currNode.data+ " ");
                    }
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static void kLevelrecursive(Node root, int level, int k){
            if (root == null) {
                return;
            }

            if (k == level) {
                System.out.print(root.data+" ");
                return;
            }

            kLevelrecursive(root.left, level+1, k);
            kLevelrecursive(root.right, level+1, k);
        }
        
    }

    public static void main(String[] args) {
       int nodes[] = {1, 2,  4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
       BinaryTree tree = new BinaryTree();
       Node root = tree.buildTree(nodes);
    //    tree.findLevelOfTree(root,3);
       tree.kLevelrecursive(root, 1, 2);
    }
}
