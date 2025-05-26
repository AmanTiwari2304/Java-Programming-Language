package Hashing.Map.Questions;

import java.util.HashMap;

public class SubarraySumK {
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int K = -10;

        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, 1);

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum-K)){
                ans += map.get(sum-K);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        System.out.println("Subarray sum equal to K -> " + ans);
    }
}
