package Heap.Assignment;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthElement {
    public static void main(String[] args) {
        int stream[] = {10, 20, 11, 70, 50, 40, 100, 5};
        int K = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < stream.length; i++) {
            pq.add(stream[i]);
            if (pq.size()>K) {
                pq.remove();
            }

            if (pq.size() == K) {
                System.out.print(pq.peek()+" ");
            } else {
                System.out.print("_ ");
            }

        }
    }
}
