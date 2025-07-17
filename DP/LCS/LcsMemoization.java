package DP.LCS;

public class LcsMemoization {
    public static int lcsMemoization(String str1, String str2, int n, int m, int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        if (dp[n][m] != -1 ) {
            return dp[n][m];
        }

        if (n == 0 || m == 0) {
            return dp[n][m] = 0;
        }

        if (str1.charAt(n-1) == str2.charAt(m-1)) {
            dp[n-1][m-1] = lcsMemoization(str1, str2, n-1, m-1, dp)+1;
            return dp[n-1][m-1];
        } else {
            int ans1 = lcsMemoization(str1, str2, n-1, m, dp);
            int ans2 = lcsMemoization(str1, str2, n, m-1, dp);
            dp[n-1][m-1] = Math.max(ans1, ans2);
            return dp[n-1][m-1];
        }
        
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        int n = str1.length();
        String str2 = "abedg"; //lcs = abdg : length = 4
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        System.out.println(lcsMemoization(str1, str2, n, m, dp));
    }
}
