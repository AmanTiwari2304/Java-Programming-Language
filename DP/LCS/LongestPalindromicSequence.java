package DP.LCS;

public class LongestPalindromicSequence {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 1) return 1;

        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = 1;
        }

        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                
            }
        }
        print(dp);
        return dp[0][n-1];
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
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}
