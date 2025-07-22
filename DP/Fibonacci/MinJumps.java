package DP.Fibonacci;

import java.util.Arrays;
// Minimum jumps to reach end of array;

public class MinJumps {
    public static int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        int dp[] = new int[n];
        
        Arrays.fill(dp, -1);
        dp[n-1] = 0;
        
        for(int i=n-2; i>=0; i--){
            int steps = arr[i];
            int minSteps = Integer.MAX_VALUE;
            for(int j = i+1; j<= i+steps && j<n; j++){
                if(dp[j] != -1){
                    minSteps = Math.min(minSteps, dp[j] + 1);
                }
            }
            
            if(minSteps != Integer.MAX_VALUE){
                dp[i] = minSteps;
            }
        }
        
        // dp[0] = 0 -> n-1
        return dp[0];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};
        System.out.println(minJumps(arr));
    }
}
