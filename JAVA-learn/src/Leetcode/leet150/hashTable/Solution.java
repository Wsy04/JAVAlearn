package Leetcode.leet150.hashTable;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper","title"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] chars = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            chars[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] > 0) return false;
        }
        return true;

    }

    public static boolean isIsomorphic(String s, String t) {
        int len = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char ct = t.charAt(i);
            if(!map.containsKey(c)){
                if(!map.containsValue(ct)){
                    map.put(c, ct);
                }else return false;
            }else if(map.get(c) != ct){
                return false;
            }
        }
        return true;
    }

    
}
