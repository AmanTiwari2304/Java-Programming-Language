package ArrayList;

import java.util.*;


public class Classroom {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void storedWater(ArrayList<Integer> ht){
        int maxStoredWater = Integer.MIN_VALUE;
        for (int i = 0; i < ht.size(); i++) {
            for (int j = i+1; j < ht.size(); j++) {
                int leastHeight = Math.min(ht.get(i), ht.get(j));
                int width = j - i;
                int trappedWater = leastHeight*width;

                if (maxStoredWater < trappedWater) {
                    maxStoredWater = trappedWater;
                }
            }
        }
        System.out.println("Maximum trapped water is : " + maxStoredWater);
    }

    // 2Pointer Approach
    public static void storedWaterOpimized(ArrayList<Integer> ht){
        int maxStoredWater = Integer.MIN_VALUE;
        int leftPointer = 0;
        int rightPointer = ht.size()-1;       

        while (leftPointer <= rightPointer) {
            int LeftPointerHeight = ht.get(leftPointer);
            int RightPointerHeight = ht.get(rightPointer);
            int leastHeight = Math.min(LeftPointerHeight, RightPointerHeight);
            int width = rightPointer - leftPointer;
            int trappedWater = leastHeight*width;

            maxStoredWater = Math.max(maxStoredWater, trappedWater);

            if (LeftPointerHeight < RightPointerHeight) {
                leftPointer++;
            }else{
                rightPointer--;
            }

            
        }

        System.out.println("Maximum trapped water is : " + maxStoredWater);
    }

    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(6);

        // int idx1 = 1, idx2 = 3;
        // swap(list, idx1, idx2);
        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);


        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>(); 
        // ArrayList<Integer> list2 = new ArrayList<>(); 
        // ArrayList<Integer> list3 = new ArrayList<>(); 

        // for (int i = 1; i <= 5; i++) {
        //     list1.add(i*1); // 1 2 3 4 5 
        //     list2.add(i*2); // 2 4 6 8 10
        //     list3.add(i*3); // 3 6 9 12 15
        // }
        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);

        // System.out.println(mainList);

        ArrayList<Integer> ht = new ArrayList<>();
        ht.add(1);
        ht.add(8);
        ht.add(6);
        ht.add(2);
        ht.add(5);
        ht.add(4);
        ht.add(8);
        ht.add(3);
        ht.add(7);

        // storedWater(ht); // O(n^2)
        storedWaterOpimized(ht);
        
    }
}
