package Stack;

import java.util.Stack;

public class ValidParenthese {
    public static boolean isValid(String str){
        Stack <Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ( ch =='(' || ch =='{' || ch =='[' ) {
                s.push(ch);
            }else{
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')')
                ||(s.peek() == '{' && ch == '}')
                ||(s.peek() == '[' && ch == ']')) {
                   s.pop(); 
                }else{
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isDublicate(String str){
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count<1) {
                    return true; //dublicate
                }else{
                    s.pop(); // opening pair
                }
            }else{
                // opening, operator, operand
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // String str = "({[()]})";
        // System.out.println(isValid(str));

        String str = "((a+b))"; // true
        String str2 = "(a-b)"; // false
        System.out.println(isDublicate(str2));
    }
}
