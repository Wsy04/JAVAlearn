package Leetcode.leet150.hashTable;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(arr));
    }

    private HashMap<Character, String> map;

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
            if (!map.containsKey(c)) {
                if (!map.containsValue(ct)) {
                    map.put(c, ct);
                } else return false;
            } else if (map.get(c) != ct) {
                return false;
            }
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strings[i])) {
                    return false;
                }
            } else if (map.containsValue(strings[i])) {
                return false;
            } else map.put(pattern.charAt(i), strings[i]);
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
        }
        return fast == 1;
    }

    public static int getNext(int n) {
        int temp = n;
        n = 0;
        while (temp > 0) {
            n += (temp % 10) * (temp % 10);
            temp /= 10;
        }
        return n;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            if (set.contains(i - 1)) continue;
            int count = 0;
            int temp = i;
            while(set.contains(temp)){
                temp++;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}

