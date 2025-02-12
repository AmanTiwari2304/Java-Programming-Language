package Recursion;

public class basic {

    public static void printNumsInDecOrder(int n){
        if (n==1) {
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        printNumsInDecOrder(n-1);
    }

    public static void printNumsIncrOrder(int n){
        if (n==10) {
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        printNumsIncrOrder(n+1);
    }

    public static int factorial(int n){
        if (n == 0) {
            return 1;
        }
        int fact = (n)*factorial(n-1);
        return fact;
    }

    public static int sumOfNums(int n){
        if(n == 1){
            return 1;
        }
        int fact = n + sumOfNums(n-1);
        return fact;
    }

    public static int fibonacciSeries(int n){
        if (n == 1 || n == 2) {
            return 1;
        }
        int num = fibonacciSeries(n-1) + fibonacciSeries(n-2);
        return  num;
    }

    public static boolean isSorted(int arr[], int i){
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccurence(int arr[], int i, int key){
        if(i == arr.length-1){
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, i+1, key);
    }

    public static int lastOccurence(int arr[], int i, int key){
        if(i == 0){
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return lastOccurence(arr, i-1, key);
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xnm1 = power(x, n-1);
        int xn = x * xnm1;
        return xn;
    }

    public static int powerObtimized(int x, int n){
        if (n == 0) {
            return 1;
        }
        int a = powerObtimized(x, n/2);
        if (n%2 == 0) {
            return a*a;
        }else{
            return a*a*x;
        }
        
    }

   

    public static void main(String[] args) {
        // int n = 10;
        // printNumsInDecOrder(n);
        // int n = 1;
        // printNumsIncrOrder(n);
        // int n = 5;
        // System.out.println(factorial(n));
        // System.out.println(sumOfNums(n));
        // System.out.print(fibonacciSeries(n)+" ");
        // int arr[] = {1, 2, 3, 5, 4};
        // System.out.println(isSorted(arr, 0));
        // int arr[] = {8, 2, 3, 5, 4, 10, 2, 5, 3};
        // System.out.println(firstOccurence(arr, 0, 2));
        // System.out.println(lastOccurence(arr, 8, 8));
        // System.out.println(power(2, 10));
        System.out.println(powerObtimized(2, 10));
       
        
    }
}
