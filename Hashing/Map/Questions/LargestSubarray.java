package Hashing.Map.Questions;

import java.util.*;

// Largest Subarray With Sum Zero :-
public class LargestSubarray {
    public static int largestSubarrayWithZeroSum(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = i+1;
            }
            else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - (map.get(sum)));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10};
        
        int lengthOfSubarray = largestSubarrayWithZeroSum(arr);
        System.out.println(lengthOfSubarray);
    }
}
