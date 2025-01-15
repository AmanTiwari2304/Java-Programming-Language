// import java.util.Scanner ;

// public class JavaBasics {
//     public static void main (String args[]) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the first number: ");
//         int num1 = sc.nextInt();
//         System.out.println("Enter the second number: ");
//         int num2 = sc.nextInt();

//         System.out.println("The sum of the two numbers is: " + (num1 + num2));
//         System.out.println("The difference of the two numbers is: " + (num1 - num2));
//         System.out.println("The product of the two numbers is: " + (num1 * num2));
//         System.out.println("The division of the two numbers is: " + (num1 / num2));
//         System.out.println("The remainder of the two numbers is: " + (num1 % num2));
        
//     }
// }


import java.util.Scanner;
public class JavaBasics{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter radius of the circle");
        float r = sc.nextFloat();

        System.out.println("Area of circle is : " + (3.14 * r * r));
    }
}


