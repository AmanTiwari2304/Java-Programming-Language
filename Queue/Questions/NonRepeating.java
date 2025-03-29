package Queue.Questions;

import java.util.*;


public class NonRepeating {
    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++; //important line

            while (!q.isEmpty() && freq[q.peek()-'a']>1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void interleaveTwoHalves(Queue<Integer> q){
        int size = q.size();
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 1; i <= size/2; i++) {
            q1.add(i);
        }
        
        for (int i = (size/2)+1; i <= size; i++) {
            q2.add(i);
        }
        
        // interleave 
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
            q2.add(q2.peek());
            q2.remove();
        }

        while (!q2.isEmpty()) {
            System.out.print(q2.peek() + " ");
            q2.remove();
        }

    }

    public static void queueReversal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());  
        }
        while (!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }

    public static void main(String[] args) {
        // String str = "aabccxb";
        // printNonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
        // interleaveTwoHalves(q);
        queueReversal(q);
        
    }
}
