package Recursion;

public class basic {

    // public static void printNumsInDecOrder(int n){
    //     if (n==1) {
    //         System.out.print(n);
    //         return;
    //     }
    //     System.out.print(n+" ");
    //     printNumsInDecOrder(n-1);
    // }

    // public static void printNumsIncrOrder(int n){
    //     if (n==10) {
    //         System.out.print(n);
    //         return;
    //     }
    //     System.out.print(n+" ");
    //     printNumsIncrOrder(n+1);
    // }

    public static int factorial(int n){
        if (n == 0) {
            return 1;
        }
        int fmn = factorial(n-1);
        int fact = (n)*fmn;
        return fact;
    }

    public static void main(String[] args) {
        // int n = 10;
        // printNumsInDecOrder(n);
        // int n = 1;
        // printNumsIncrOrder(n);
        int n = 5;
        System.out.println(factorial(n));
    }
}
