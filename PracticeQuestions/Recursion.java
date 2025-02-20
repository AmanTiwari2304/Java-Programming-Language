public class Recursion {
    public static void allOccurrences(int arr[], int key, int i){
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.print(i+" ");
        }
        allOccurrences(arr, key, i+1);
    }

    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void printDigit(int n){
        if (n==0) {
            return;
        }
        int lastDigit = n%10;
        printDigit(n/10);
        System.out.print(digits[lastDigit]+" ");
    }

    public static int lengthOfString(String str){
        // Base
        if (str.equals("")) {
            return 0;
        }
        return 1+ lengthOfString(str.substring(1));
    }

    public static void towerOfHanoi(int n, String sour, String helper,String dest){
        // Base 
        if (n==1) {
            System.out.println("Transfer disk " + n + " from " + sour + " to " + dest);
            return;
        }
        towerOfHanoi(n-1, sour, dest, helper);
        System.out.println("Transfer disk " + n + " from " + sour + " to " + dest);
        towerOfHanoi(n-1, helper, sour, dest);
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        allOccurrences(arr, key, 0);
        // printDigit(1235);
        // String str = "Hello";
        // System.out.println(lengthOfString(str));
        // int n = 3;
        // towerOfHanoi(n, "S", "H", "D");
        
    }
}
