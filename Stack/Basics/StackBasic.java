package Stack.Basics;

import java.util.ArrayList;

public class StackBasic {
    static class StackWithArrayList{
        static ArrayList<Integer> list = new ArrayList<>();

        // isEmpty
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        // Push
        public static void push(int data){
            list.add(data);
        }

        // Pop
        public static int pop(){
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        // Peek
        public static int peek(){
            int top = list.get(list.size()-1);
            return top;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class StackWithLinkedList {
        static Node head = null;

        // IsEmpty
        public static boolean isEmpty(){
            return head == null;
        }

        // Push
        public static void push(int data){
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        // Pop
        public static int pop(){
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
            
        }

        // Peek
        public static int peek(){
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            return top;
        }


    }

    public static void main(String[] args) {
        // StackWithArrayList s = new StackWithArrayList();
        StackWithLinkedList s = new StackWithLinkedList();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }



    }
}
