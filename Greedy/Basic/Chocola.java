package Greedy.Basic;

import java.util.*;


public class Chocola {
    public static void main(String[] args) {
        Integer costVer[] = {2, 1, 3, 1, 4}; //Vertical Cut Cost
        Integer costHor[] = {4, 1, 2}; //Horizontal Cut Cost

        Arrays.sort(costVer, Collections.reverseOrder()); //descending order
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; //horizontal and vertical cut
        int hp = 1, vp = 1; //horizontal and vertical pieces
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) { //horizontal cut
                cost += (costHor[h]*vp);
                hp++;
                h++;
            }else{ //vertical cut
                cost += (costVer[v]*hp);
                vp++;
                v++; 
            }
        }
        while (h < costHor.length){
            cost += (costHor[h]*vp);
            hp++;
            h++;
        }
        while (v < costVer.length) {
            cost += (costVer[v]*hp);
            vp++;
            v++;
        }
        System.out.println("Minimum cost of cut " + cost);
    }
    
    
}
