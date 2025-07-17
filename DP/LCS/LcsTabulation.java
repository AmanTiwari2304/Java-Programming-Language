package DP.LCS;

public class LcsTabulation {
    public static int lcsTabulation(String str1, String str2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        print(dp);
        return dp[n][m];
    }
    public static void print(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        int n = str1.length();
        String str2 = "abedg"; //lcs = abdg : length = 4
        int m = str2.length();
        lcsTabulation(str1, str2, n, m);
    }
}
