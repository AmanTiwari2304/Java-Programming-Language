package Hashing.Map.TreeMap;

import java.util.HashMap;
import java.util.TreeMap;

public class Classroom {
    public static void main(String[] args) {
        TreeMap<String,Integer> tm = new TreeMap<>();
        // Insert
        tm.put("India", 140);
        tm.put("China", 150);
        tm.put("USA", 50);
        tm.put("Bhutan", 3);

        HashMap<String, Integer> hm = new HashMap<>();
        // Insert
        hm.put("India", 140);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("Bhutan", 3);

        System.out.println(hm);// output in random order
        System.out.println(tm);// output in sorted order
    }
}
