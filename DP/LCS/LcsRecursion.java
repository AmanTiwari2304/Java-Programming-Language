package DP.LCS;

public class LcsRecursion {
    public static int lcsRecursion(String str1, String str2, int n, int m){
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            return lcsRecursion(str1, str2, n-1, m-1)+1;
        } else {
            int ans1 = lcsRecursion(str1, str2, n-1, m);
            int ans2 = lcsRecursion(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        int n = str1.length();
        String str2 = "abedg"; //lcs = abdg : length = 4
        int m = str2.length();
        System.out.println(lcsRecursion(str1, str2, n, m));
    }
}
