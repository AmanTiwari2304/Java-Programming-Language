import java.util.*;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character,Integer> map =new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char givenChar = s.charAt(i);
            map.put(givenChar, map.getOrDefault(givenChar, 0)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }else{
                return false;
            }
        }

        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "rafes";
        String t = "farse";
        
        System.out.println(isAnagram(s,t)); //O(n)
    }
}
