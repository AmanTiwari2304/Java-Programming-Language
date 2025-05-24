package Hashing.Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Set;

public class Classroom {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 150);
        lhm.put("China", 140);
        lhm.put("US", 50);
        lhm.put("Indonesia", 6);

        System.out.println(lhm);
        
        // Get
        int population = lhm.get("India");
        System.out.println("Population of India is " + population);

        // Return null value for unknown key
        System.out.println(lhm.get("Indonesia"));

        // ContainsKey ? (Boolean -> return true or false)
        System.out.println(lhm.containsKey("India")); //true
        System.out.println(lhm.containsKey("Indonesia")); // false

        // Remove
        System.out.println(lhm.remove("China"));
        System.out.println(lhm);

        // Size
        System.out.println(lhm.size());

        // isEmpty
        // lhm.clear(); // to clear Haslhmap completely
        System.out.println(lhm.isEmpty());

        // Iteration 
        Set<String> keys = lhm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = "+ k + ", Value = "+ lhm.get(k));
        }
    }
}
