package DP.LCS;

public class WildcardMatching {
    public static boolean wildcardMatching(String s, String p){
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];

        // initilisation
        dp[0][0] = true;
        // pattern = " "
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }
        // string s = " "
        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }else{ // if p is '?' or any character
                dp[0][j] = false;
            }
        }

        // Bottom to up
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // case -> ith char == jth char || jth char == '?'
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1]; // remove char from both string
                }else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";
        System.out.println(wildcardMatching(s, p));
    }
}
