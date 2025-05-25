package Hashing.Set.Questions;

import java.util.HashSet;

public class CountDistinctEle {
    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        System.out.println(set);
        System.out.println(set.size()); 
    }
}
