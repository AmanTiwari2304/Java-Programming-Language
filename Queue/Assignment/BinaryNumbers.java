package Queue.Assignment;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbers {
    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < N; i++) {
            String binary = queue.poll();
            System.out.print(binary + " ");

            queue.add(binary + "0");
            queue.add(binary + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;  // Example input
        generateBinaryNumbers(N);
    }
}


