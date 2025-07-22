package DP.Catalan;

public class CountBST {
    public static int countBST(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1; // if zero node or one node then there is one possible ways

        for (int i = 2; i < dp.length; i++) { // BST for i nodes -> dp[i]
            for (int j = 0; j < i; j++) {
                int left = dp[j]; // No. of left nodes
                int right = dp[i-j-1]; // No. of right nodes
                dp[i] += left * right;
            }
        }

        return dp[n];

    }
    public static void main(String[] args) {
        int n = 5;// number of nodes; if an arr is given then the length of array will be n
        System.out.println("Number of BST possible : " + countBST(n));
    }
}
