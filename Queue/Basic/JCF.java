package Queue.Basic;
import java.util.*;
public class JCF {
    public static void main(String[] args) {
        // Queue is a Interface that's why it have not it's own constructor
        // We can use the contructor of LL and ArrayDeque
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
        
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
