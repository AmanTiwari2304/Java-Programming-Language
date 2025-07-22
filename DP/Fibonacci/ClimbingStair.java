package DP.Fibonacci;

public class ClimbingStair {
    // recursion  - (2^n)
    public static int countWays(int n){
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n-1) + countWays(n-2); 

    }

    // memorization - O(n)
    public static int memoCountWays(int n, int dp[]){
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = memoCountWays(n-1, dp) + memoCountWays(n-2, dp);
        return dp[n];
    }

    // Tabulation - O(n)
    public static int tabCountWays(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countWays(n));
        int dp[] = new int[n+1];
        System.out.println(memoCountWays(n, dp));
        System.out.println(tabCountWays(n));

    }
}
