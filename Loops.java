import java.util.*;

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sum of Even and Odd interger given by user:
        // int number;
        // int choice ;
        // int evenSum = 0;
        // int oddSum = 0;

        // do {
        //     System.out.print("Enter the number ");
        //     number = sc.nextInt();
        //     if (number%2 == 0) {
        //         evenSum = evenSum + number;
        //     } else {
        //         oddSum = oddSum + number;
        //     }
        //     System.out.print("If you want to continue press 1 otherwise press 0 ");
        //     choice = sc.nextInt();
        // } while (choice == 1);

        // System.out.println("Sum of Even number is : " + evenSum);
        // System.out.println("Sum of Odd number is : " + oddSum);



        //Multiplication table: 
        // System.out.println("Enter a number whose table you want : ");
        // int n = sc.nextInt();
        // int nt = 0;
        // for (int i = 1; i <= 10; i++) {
        //     nt = n*i;
        //     System.out.println(nt);
        // }


        // Factorail of a number:
        System.out.print("Enter the number ");
          int n = sc.nextInt();
          int fact = 1;
          if ((n==0)&&(n==1)) {
            System.out.println("Factorail of your number is 1" );
          } else {
            for (int i = 0; i < n; i++) {
                fact = fact * (n-i);
              }
            System.out.println("Factorail of your number is " + fact);
          }
          
        
    }
}
