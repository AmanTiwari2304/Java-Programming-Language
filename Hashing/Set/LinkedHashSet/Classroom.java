package Hashing.Set.LinkedHashSet;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Classroom {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Kolkata");
        cities.add("Chennai");
        System.out.println(cities);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Kolkata");
        lhs.add("Chennai");
        System.out.println(lhs);
    }
}
