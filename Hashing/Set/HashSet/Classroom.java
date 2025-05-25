package Hashing.Set.HashSet;

import java.util.*;

public class Classroom {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Kolkata");
        cities.add("Chennai");

        // using iterator`
        Iterator it = cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // Advance method
        for (String city : cities) {
            System.out.println(city);
        }
    }
    
        
}
