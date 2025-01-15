package Operators;
import java.util.Scanner;
public class ConditionalStatement {
    public static void main(String[] args) {
        // Print if a number is even or odd
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter your number : ");
        // int num = sc.nextInt();
        // if (num % 2 == 0) {
        //     System.out.println(num + " is even");
        // } else {
        //     System.out.println(num + " is odd");
        // }

        //Income Tax Calculator : - 
        System.out.println("Enter your income  : ");
        Float income = sc.nextFloat();
        if (income < 500000 ) {
            System.out.println("Your have not need to pay taxes");
        } else if(income >= 500000 && income < 1000000){
            System.out.println("Your have to pay 20% of your income as a taxes, which is equal to : " + (income*(0.2)));
        }else{
            System.out.println("Your have to pay 30% of your income as a taxes, which is equal to : " + (income*(0.3)));
        }
    }
}
