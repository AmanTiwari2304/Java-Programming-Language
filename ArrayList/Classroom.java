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

    public static void pairSumBruteForce(ArrayList<Integer> list1, int target){
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i+1; j < list1.size(); j++) {
                if (list1.get(i)+list1.get(j) == target) {
                    System.out.println("("+list1.get(i) +", "+list1.get(j) +")");
                }
            }
        }
    }

    public static void pairSumOptimized(ArrayList<Integer> list1, int target){
        int lp = 0;
        int rp = list1.size()-1;

        while (lp<rp) {
            if (list1.get(lp) + list1.get(rp) == target) {
                System.out.println("("+list1.get(lp) +", "+list1.get(rp) +")");
                lp++; 
                rp--;
            }
            else if(list1.get(lp) + list1.get(rp) > target){
                rp--;
            }
            else{
                lp++;
            }
        }
    }

    public static int[] getLpAndRp(ArrayList<Integer> list2){
        int lp = -1;
        int rp = -1;
        for (int i = 0; i < list2.size() - 1; i++) {
            if (list2.get(i) > list2.get(i + 1)) {
                lp = i + 1;
                rp = i;
                break;
            }
        }
        return new int[]{lp, rp}; // return both lp and rp
    }

    public static void pairSumInSortedRotated(ArrayList<Integer> list2, int target){
        getLpAndRp(list2);
        int[] lpAndRp = getLpAndRp(list2);
        int lp = lpAndRp[0];
        int rp = lpAndRp[1];

        while (lp!=rp){        
            if(list2.get(lp) + list2.get(rp) == target) {
                System.out.println("("+list2.get(lp) +", "+list2.get(rp) +")");
                lp++;
                if (lp == list2.size()-1) {
                    lp = 0;
                } 
                rp--;
                if (rp == 0) {
                    rp = list2.size()-1;
                }
            }
            else if(list2.get(lp) + list2.get(rp) > target){
                rp--;
                if (rp == 0) {
                    rp = list2.size()-1;
                }
            }
            else{
                lp++;
                if (lp == list2.size()-1) {
                    lp = 0;
                }
            }
        }
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
        // storedWaterOpimized(ht); //O(n)

        // ArrayList<Integer> list1 = new ArrayList<>(); 
        // for (int i = 1; i <= 6; i++) {
        //         list1.add(i); // 1 2 3 4 5 6     
        // }
        // int target = 5;

        // pairSumBruteForce(list1, target); // O(n^2)
        // pairSumOptimized(list1, target); // O(n)

        ArrayList<Integer> list2 = new ArrayList<>(); 
        list2.add(11);
        list2.add(15);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        int target = 16;

        pairSumInSortedRotated(list2, target);

    }
}
