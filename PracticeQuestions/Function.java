 
import java.util.*;

public class Function {
    public static int averageOfNum(int a, int b, int c){
        int average = (a + b + c)/3;
        System.out.println(average);
        return average;
       
    }

    public static boolean isEven(int n){
        if (n % 2 == 0) {
            System.out.println("It is even");
            return true;
        } else {
            System.out.println("It is odd");
            return false;
        }
    }

    public static int isPalindrome(int n ){
        int originalNum = n;
        int newNum = 0;
        while (n > 0) {
            int r = n % 10;
            newNum = (newNum * 10 ) + r ;
            n = n / 10;
        }
        if (originalNum == newNum) {
            System.out.println(originalNum + " is a palindrome");
        } else {
            System.out.println(originalNum + " is not a palindrome");
        }
        return originalNum;
    }

    public static int calculateSumOfDigit(int n ){
        int originalNum = n;
        int newNum = 0;
        while (n > 0) {
            int r = n % 10;
            newNum = (newNum) + r ;
            n = n / 10;
        }
        System.out.println("Sum of digits in the " + originalNum + " is : " + newNum);
        return originalNum;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int c = sc.nextInt();
        // averageOfNum(a, b, c);

        int n = sc.nextInt();
        // isEven(n);
        // isPalindrome(n);
        calculateSumOfDigit(n);
        
    }
}
