package Greedy.Basic;

import java.util.*;

public class MaxActivity {
    public static void maxNumActivitySortedArray(int start[], int end[]){
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                // activity select
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Max activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
    }

    public static void maxNumActivity(int start[], int end[]){
        // sorting
        int activities[][] = new int[start.length][3];
        // Here i -> row and 0,1,2 are column number
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i; //store initial index
            activities[i][1] = start[i]; 
            activities[i][2] = end[i];
        }
        // lamda function -> short form
        // sorting of column 3  
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        
        
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                // activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ans.get(i)+" ");
        }
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // maxNumActivitySortedArray(start, end);
        maxNumActivity(start, end); // unsorted ends of array
        
    }
}
