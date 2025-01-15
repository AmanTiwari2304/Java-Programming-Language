
import java.util.*;
public class NestedLoops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stars you want : ");
        int n = sc.nextInt();
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j<= i; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }


        // Inverted Stars : 
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j<= (n-i)+1; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // Half-Pyramid Pattern With number :-
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j<= i; j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        // Print Character Pattern :- 
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<= i; j++){
                System.out.print(ch);
                ch++;
            }

            System.out.println();
            // ch++;
        }
    }
}
