package Leetcode.leet150.hashTable;

public class Solution {
    public static void main(String[] args) {
        System.out.println(canConstruct("aab","baa"));
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
}
