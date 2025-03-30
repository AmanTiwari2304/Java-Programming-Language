package Queue.Deque;

import java.util.Deque;
import java.util.LinkedList;


public class queueWithDeque {
    static class Queue{
        static Deque<Integer> deque = new LinkedList<>();

        public static boolean isEmpty(){
            return deque.isEmpty();
        }

        public static void add(int data){
            deque.addLast(data);
        }

        public static int remove(){
            if (deque.isEmpty()) {
                System.out.println("Already empty");
                return -1;
            }
            return deque.removeFirst();
        }

        public static int peek(){
            if (deque.isEmpty()) {
                System.out.println("Already empty");
                return -1;
            }
            return deque.getFirst();  
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
        
    }
}
