import java.util.Scanner;

public class Functions {
    public static int productOFTwoNum(int a, int b) {
        int product = a * b;
        return product;
    }

    public static int factorial(int n){
        int fact = 1;
        for(int i=1; i<=n; i++){
            fact = fact*i;
        }
        return fact;
    }

    public static int BinomailCoefficient(int n , int r) {
        int NCR = factorial(n)/(factorial(r)*factorial(n-r));
        return NCR;
    }

    public static boolean isPrime(int n){
        if(n == 2){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter First Number : ");
        // int a = sc.nextInt();
        // System.out.println("Enter Second Number : ");
        // int b = sc.nextInt();

        // int result = productOFTwoNum(a, b);
        // System.out.println("Product of the two numbers is: " + result);
 
        //Factorial: 
        // System.out.println("Enter the value of n :");
        // int n = sc.nextInt();

        // int res = factorial(n);
        // System.out.println("Factorial of "+ n + " is "+ res);

        // BinomailCoefficient
        // System.out.println("Enter the value of r :");
        // int r = sc.nextInt();
        
        // int BinomailCoefficient = BinomailCoefficient(n, r);
        // System.out.println("BinomialCoefficient is equal to : " + BinomailCoefficient);

        //Print all the prime number upto n :
        System.out.println("Enter the value of n :");
        int n = sc.nextInt();

        for(int i = 2; i<= n; i++){
            if (isPrime(i) == true) {
                System.out.print( i +" ,");
            }
        }
    }
}