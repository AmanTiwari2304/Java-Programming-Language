package Recursion;

public class recursionAdvance {

    public static int tilingProblem(int n){
        if (n==0 || n==1) {
            return 1;
        }
        int vertical = tilingProblem(n-1);
        int horizontal = tilingProblem(n-2);
        int totalWays = vertical + horizontal;
        return totalWays;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){
        // Base
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        // Kaam 
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicates(str, idx+1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int friendsPair(int n){
        // Base 
        if (n==1 || n==2) {
            return n;
        }
        // Kaam
        int single = friendsPair(n-1);
        int pair = (n-1)*friendsPair(n-2); // (n-1) -> pairChoices & f(n-2) -> 1 pair ways
        int numOfWays = single + pair;
        return numOfWays;
    }

    public static void printBinString(int n, int lastPlace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }

        printBinString(n-1, 0, str+"0");
        if (lastPlace == 0) {
            printBinString(n-1, 1, str+"1");  
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(tilingProblem(4));
        // String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
        // int n = 3; //number of people
        // System.out.println(friendsPair(n));
        printBinString(3, 0, "");
    }
}
