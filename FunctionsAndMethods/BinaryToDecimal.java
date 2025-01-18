import java.util.Scanner;

public class BinaryToDecimal {
    public static void ChangeBinaryToDecimal(long n) {
        long digit = 0;
        long i = 0;

        while (n > 0) {
            long r = n % 10;
            digit = digit + (long)(r * (Math.pow(2, i)));
            n = n / 10;
            i++;
        }
        System.out.println(digit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your binary number: ");
        long n = sc.nextInt();
        ChangeBinaryToDecimal(n);
    }
}
