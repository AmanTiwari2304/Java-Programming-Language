package Strings;
import java.util.*;

public class Strings {
    public static void printLetters(String str){
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static boolean isPalindrome(String str){
        int n = str.length();
        for (int i = 0; i < (n)/2; i++) {
            if (str.charAt(i) != str.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void shortestPath(String desti){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your x cordinate : ");
        int x1 = sc.nextInt();
        System.out.println("Enter your y cordinate : ");
        int y1 = sc.nextInt();
        int x2 = 0;
        int y2 = 0;

        for (int i = 0; i < desti.length(); i++) {
            char dir = desti.charAt(i);
            //West
            if (dir == 'W') {
                x2--;
            }
            // North
            else if (dir == 'N') {
                y2++;
            }
            // South
            else if (dir == 'S') {
                y2--;
            }
            // East
            else {
                x2++;
            }
        }

        float xaxis = (float)Math.pow((x2 - x1),2 );
        float yaxis = (float)Math.pow((y2 - y1),2);
        float finalDestination = (float)Math.sqrt(xaxis +yaxis);

        System.out.println("Our final distination is " + finalDestination + " unit away from our intial value");
    }

    public static String subString(String str){
        Scanner sc = new Scanner(System.in);
        String substr = "";
        System.out.println("Enter the starting point : " );
        int si = sc.nextInt();
        System.out.println("Enter the ending point : " );
        int ei = sc.nextInt();
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }

    public static String largestString(){
        String fruits[] = {"apple", "mango", "banana"};
        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareToIgnoreCase(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'd'};
        String str = "caffac";
        String desti = "WNWWNWSENNN" ;
        // printLetters(str);
        // System.out.println(isPalindrome(str));
        // shortestPath(desti);
        // System.out.println(subString(str));
        // System.out.println(str.substring(0,5 ));
        System.out.println(largestString());

    }
}
