package DP.Fibonacci;

public class Classroom {
    // Memoization
    public static int fibo(int n, int f[]){
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = fibo(n-1, f) + fibo(n-2, f);
        return f[n];
    }

    // Tabulation
    public static int fibTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 0; 
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int f[] = new int[n+1];

        System.out.println(fibo(n, f));
        System.out.println(fibTabulation(n));

    }
}
