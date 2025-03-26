package Stack.Assignment;
import java.util.*;

public class isPalindrome {
    public static boolean isPalindromeLL(LinkedList<Character> list){
        Stack<Character> s = new Stack<>();
        // Push all the element
        for(char ch : list){
            s.push(ch);
        }
        
        // Check 
        for(char ch : list){
            if (ch != s.pop()) {
                return false;
            }
        }
        return true;
    }
   public static void main(String[] args) {
    LinkedList<Character> list = new LinkedList<>();
    list.add('A');
    list.add('B');
    list.add('C');
    list.add('B');
    list.add('A');
    if (isPalindromeLL(list)) {
        System.out.println("Yes, It is Palindrome");
    } else {
        System.out.println("Not a Palindrome");
    }
   }
}
