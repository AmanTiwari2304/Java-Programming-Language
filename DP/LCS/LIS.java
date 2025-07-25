package DP.LCS;
// Longest Increasing Subsequence

import java.util.*;

public class LIS {
    public static int longestIncreasingSubsequence(int arr1[]){
        HashSet<Integer> set = new HashSet<>();
        for (Integer arr : arr1) {
            set.add(arr);
        }

        // store all the value of set in array list
        ArrayList<Integer> arrList = new ArrayList<>(set);

        Collections.sort(arrList);
        
        int arr2[] = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            arr2[i] = arrList.get(i);
        }

        // Longest Common Subsequence
        return lcs(arr1, arr2);
    }

    public static int lcs(int arr1[] , int arr2[]){
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n+1][m+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    // EASIEST WAY
    public static int lis(int arr[]){
        int n = arr.length;
        int LIS[] = new int[n];

        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    LIS[i] = Math.max(LIS[i], LIS[j]+1);
                }
                
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, LIS[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int arr1[] = {50, 3, 10, 7, 40, 80};
        // System.out.println(longestIncreasingSubsequence(arr1));
        System.out.println(lis(arr1));
    }
}
