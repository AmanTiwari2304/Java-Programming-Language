import java.util.*;
public class MyString {
    public static int numOfVowel(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) {
                count ++;
            }
        }
        return count;
    }

    public static boolean isAnagram(String str1 , String str2) {
        if (str1.length() == str2.length()) {
            return false;
        }
        String.sort(str1);
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first string : ");
        String str1 = sc.nextLine();
        System.out.println("Enter your second string : ");
        String str2 = sc.nextLine();

        // System.out.println(numOfVowel(str));
        System.out.println(isAnagram(str1, str2));

    }
}
