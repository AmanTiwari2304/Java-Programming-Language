package Hashing.Set.TreeSet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Classroom {
    public static void main(String[] args) {
        // Random order
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Kolkata");
        cities.add("Chennai");
        System.out.println(cities);

        // Same order as input 
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Kolkata");
        lhs.add("Chennai");
        System.out.println(lhs);

        // Sorted in ascending order
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Kolkata");
        ts.add("Chennai");
        System.out.println(ts);        
    }    
}
