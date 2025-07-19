package DP.LCS;

public class LongestCommonSubstring {
    public static int longestCommonSubstring(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int maxLength = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        String str1 = "abcdgh";
        String str2 = "acdghr";
        System.out.println(longestCommonSubstring(str1, str2));
    }
}
