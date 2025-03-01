package LinkedList;
import java.util.LinkedList;
public class JCFLL {
    public static void main(String[] args) {
        // Create - 
        LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.addFirst(0);
        ll.addLast(1);
        ll.addLast(2);

        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);

    }
}
