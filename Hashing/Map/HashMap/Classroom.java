package Hashing.Map.HashMap;
import java.util.*;

public class Classroom {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert
        hm.put("India", 140);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("Bhutan", 3);

        System.out.println(hm);

        // Get
        int population = hm.get("India");
        System.out.println("Population of India is " + population);

        // Return null value for unknown key
        System.out.println(hm.get("Indonesia"));

        // ContainsKey ? (Boolean -> return true or false)
        System.out.println(hm.containsKey("India")); //true
        System.out.println(hm.containsKey("Indonesia")); // false

        // Remove
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        // Size
        System.out.println(hm.size());

        // isEmpty
        // hm.clear(); // to clear HashMap completely
        System.out.println(hm.isEmpty());

        // Iteration 
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = "+ k + ", Value = "+ hm.get(k));
        }
    }
}
