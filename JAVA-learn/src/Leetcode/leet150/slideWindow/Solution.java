package Leetcode.leet150.slideWindow;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "A", t = "A";
        System.out.println(minWindow(s, t));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int dec = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            dec += nums[i];
            while (dec >= target) {
                ans = Math.min(ans, i - start + 1);
                dec -= nums[start];
                start++;
            }
        }
        return ans == n + 1 ? 0 : ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashtable = new HashMap<>();
        int ans = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashtable.containsKey(s.charAt(i))) {
                start = Math.max(start, hashtable.get(s.charAt(i)) + 1);
                hashtable.replace(s.charAt(i), i);
            } else hashtable.put(s.charAt(i), i);
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int m = words.length;
        int n = words[0].length();
        int ls = s.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) break;
            //记录滑动窗口中各单词的数量和words中各单词数量之差
            HashMap<String, Integer> differ = new HashMap<String, Integer>();
            //初始化滑动窗口,长度为m个单词
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + j * n + n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);//若不存在则设置为0再加1，不然直接加1
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0)
                    differ.remove(word);
            }
            for (int start = i; start + m * n - 1 < ls; start += n) {
                if (start != i) {//初始检查之后开始移动窗口
                    String word = s.substring(start + (m - 1) * n, start + m * n);//窗口末端即为新加入的单词
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0)
                        differ.remove(word);
                    word = s.substring(start - n, start);//窗口外部前端为最近舍弃的单词
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0)
                        differ.remove(word);
                }
                if (differ.isEmpty()) {
                    ans.add(start);
                }
            }
        }
        return ans;
    }

    public static String minWindow(String s, String t) {
        int left = 0, right = 0;
        int ansL = -1;
        int minLen = s.length() + 1;
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int[] window = new int[128];
        int count = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (need[r] > 0) {//所需的字符进入区间
                if(window[r]++ < need[r])//窗口一定增加,count值只有未覆盖才增加
                    count++;
            }
            while (count == t.length() && left <= right) {//已经完成覆盖
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ansL = left;
                }
                char l = s.charAt(left);
                if (need[l] > 0) {
                    if(need[l] == window[l])//影响了覆盖的情况
                        count--;
                    window[l]--;//无论如何必须从窗口中去除
                }
                left++;
            }
            right++;
        }

        return ansL == -1 ? "" : s.substring(ansL, ansL + minLen);
    }
}
