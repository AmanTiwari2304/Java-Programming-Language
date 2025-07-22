package DP.MartixGrid;

import java.util.Arrays;
// Minimum cost of multiplication 
public class MatrixChainMultiplication {
    public static int mcm(int arr[], int i, int j){
        // Base Case
        int ans = Integer.MAX_VALUE;
        if(i == j) return 0;
        for (int k = i; k < j; k++) {
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);            
        }
        return ans;
    }

    
    public static void main(String[] args) {
        int arr [] =  {1, 3, 5, 6};
        int i = 1;
        int j = arr.length-1;
        System.out.println(mcm(arr, i, j));
    }    
}
