package Loops;
import java.util.*;
public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Print number from 1 to 10 : 
        // int counter = 1 ;
        // while (counter <= 10) {
        //     System.out.println(counter);
        //     counter++ ;
        // }

        // Print number from 1 to n : 
        // System.out.println("Enter upto you want to print your number : ");
        // int num = 1;
        // int n = sc.nextInt();
        // while (num <= n) {
        //     System.out.println(num);
        //     num++;
        // }

        // Print sum of first n natural numbers : 
        // System.out.println("Enter the number upto you want there sum :");
        // int n = sc.nextInt();
        // int i = 1;
        // int sum = 0;
        // while (i <= n) {
        //     sum = sum + i;
        //     i ++ ;
            
        // }
        // System.out.println(sum);

        // Print reverse of a number :
        // for (int n = 10899; n > 0 ; n/=10) {
        //     int lastDigit = n%10;
        //     System.out.print(lastDigit);
        // }

        // Print reverse of a given number : 
        // int n = 10899;
        // int rev = 0;
        // while (n > 0) {
        //     int lastDigit = n % 10;
        //     rev = (rev*10) + lastDigit;
        //     n = n/10;
        // }
        // System.out.print(rev);

        // Break Statement :
        
        // while (1>0) {
        //     System.out.println("Guess a number : "); 
        //     int yournum = sc.nextInt();
        //     if (yournum % 10 == 0 ) {
        //         System.out.println("The secret is number should be the multiple of 10");
        //         break;
        //     }
        // }

        // Continue Statement :
        // System.out.println("Enter some numbers : ");  
        // while (1>0) {
        //     int yournum = sc.nextInt();
        //     if (yournum % 10 == 0 ) {
        //         System.out.println("We are not going to display a number multiple of 10");
        //         continue;
        //     }
        // }

        // Check if a number is prime or not : 
        System.out.println("Enter a number ");
        int n = sc.nextInt();

        if (n == 2) {
            System.out.println("This is prime number");
        }else{
            boolean isPrime = true;
            for(int i=2; i<=Math.sqrt(n); i++) {
                if(n % i == 0){ // n is a multiple of i (i is not equal to 1 or n)
                    isPrime = false;
                }
            }
    
            if(isPrime == true){
                System.out.println("This is prime number");
            }else{
                System.out.println("This is not a prime number");
            }
        }

      
    }
}
