package Hashing.Set.Questions;

import java.util.HashSet;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> union = new HashSet<>();
        for (Integer arr : arr1) {
            union.add(arr);
        }
        for (Integer arr : arr2) {
            union.add(arr);
        }
        System.out.println("Union = " + union.size() + union);

        HashSet<Integer> intersection = new HashSet<>();
        for (Integer arr : arr1) {
            intersection.add(arr);
        }

        int count = 0;
        for (Integer arr : arr2) {
            if (intersection.contains(arr)) {
                intersection.remove(arr);
                count ++;
            }    
        }
        System.out.println("Intersection = " + count);


    }
}
