
import java.util.Scanner;
public class ConditionalStatement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    //     // Whether it is positive or negative 
    //     System.out.println("Enter your number");
    //     int num = sc.nextInt();
    //     if (num >= 0) {
    //         System.out.println("Your number is positive");
    //     } else {
    //         System.out.println("Your number is negative");
    //     }


            // // IF You have fever or not 
            // System.out.println("Please Enter your body temperature as in termometer ");
            // float temp = sc.nextFloat();
            // if (temp > 100) {
            //     System.out.println("You have a fever");
            // } else {
            //     System.out.println("You don't have a fever");
            // }




            //Whether year is leap or not 

            System.out.println("Enter the year you want to check : ");
            int year = sc.nextInt();
            if (year % 4 == 0 ) {
                if (year % 100 == 0) {
                  if (year % 400 == 0) {
                    System.out.println("This is a leap year");
                  } else {
                    System.out.println("This is not a leap year");
                  }  
                } else {
                    System.out.println("This is a leap year");   
                }
            } else {
                System.out.println("This is not a leap year");
            }
    }
}
