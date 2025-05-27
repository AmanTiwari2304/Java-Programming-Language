package Hashing.Assignment;

import java.util.HashMap;

public class SortByFreq {
    public static void main(String[] args) {
        String str = "tree";
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);
    }
}
