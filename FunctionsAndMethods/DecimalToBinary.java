import java.util.*;

public class DecimalToBinary {
    public static void DecToBin(int n){
        // int binNum = 0;
        // int pow = 0;
        // while (n > 0) {
        //     int lastDigit = 0;
        //     lastDigit = n % 2 ;
        //     binNum = binNum + (lastDigit*(int)(Math.pow(10, pow)));

        //     pow++;
        //     n = n /2 ;

        // }

        // System.out.print(binNum);

        String binary = "";
        int num = n;

        while (num > 0) {
            int rem = num % 2;
            binary = rem + binary;
            num = num / 2;
        }

        System.out.println(binary);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number: ");
        int n = sc.nextInt();
        DecToBin(n);
    }
}
