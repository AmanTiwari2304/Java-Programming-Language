package BinaryTree.Questions;

import Queue.Deque.stackWithDeque;
import Recursion.recursionAdvance;

public class HeightOfATree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
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
       
        public static int heightOfTree(Node root){
            int height = 0;
            int lh = 0 , rh = 0;
            if (root == null) {
                return 0;
            }
            lh = heightOfTree(root.left);
            rh = heightOfTree(root.right);

            height = Math.max(lh, rh) + 1;

            return height;
        }

        public static int countOfNodes(Node root){
            int count = 0;
            if (root == null) {
                return 0;
            }
            int leftCount = countOfNodes(root.left);
            int rightCount = countOfNodes(root.right);
            return count = leftCount + rightCount + 1;
        }

        public static int sumOfNodes(Node root){
            int sum = 0;
            if (root == null) {
                return 0;
            }
            int leftsum = sumOfNodes(root.left);
            int rightsum = sumOfNodes(root.right);
            return sum = leftsum + rightsum + root.data;
        }

        public static int diameterOfTree(Node root){ //O(n^2)
            if (root == null) {
                return 0;
            }
            int leftdiam = diameterOfTree(root.left);
            int rightdiam = diameterOfTree(root.right);
            int lheight = heightOfTree(root.left);
            int rheight = heightOfTree(root.right);
            int selfdiam = lheight + rheight +1;
            return  Math.max(selfdiam, Math.max(rightdiam, selfdiam));
        }

        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
            
        }
        public static Info diameter(Node root){
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diam, ht);

        }
    }
    public static void main(String[] args) {
       int nodes[] = {1, 2,  4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
       BinaryTree tree = new BinaryTree();
       Node root = tree.buildTree(nodes);
       
   
        //   System.out.println(tree.heightOfTree(root));
        //   System.out.println(tree.countOfNodes(root));
        //   System.out.println(tree.sumOfNodes(root));
        //   System.out.println(tree.diameterOfTree(root));
            System.out.println(tree.diameter(root).diam);


    }
}
