package Collection.Map;

import java.util.TreeMap;

public class MapDemo3 {
    public static void main(String[] args) {
        String s = "ysefedeosekhykgrjmfewkshyurkfwjkmascuhy";
        TreeMap<Character, Integer> map = new TreeMap<>((o1, o2) -> o1-o2);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
