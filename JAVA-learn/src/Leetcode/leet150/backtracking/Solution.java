package Leetcode.leet150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> result;
    private static boolean[] visited;

    public static List<String> letterCombinations(String digits) {
        String[] letters = new String[8];
        letters[0] = "abc";
        letters[1] = "def";
        letters[2] = "ghi";
        letters[3] = "jkl";
        letters[4] = "mno";
        letters[5] = "pqrs";
        letters[6] = "tuv";
        letters[7] = "wxyz";
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(result,digits,0,letters,new StringBuilder());
        return result;
    }

    public static void backtrack(List<String> result, String digits, int index, String[] letters,StringBuilder cur) {
        if (index == digits.length()) {
            result.add(cur.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letter = letters[digit-2];
        for (int i = 0; i < letter.length(); i++) {
            cur.append(letter.charAt(i));
            backtrack(result, digits, index+1, letters, cur);
            cur.deleteCharAt(cur.length()-1);
        }

    }

    public static List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        back(list,n,k);
        return result;
    }

    public static void back(List<Integer> list,int n,int k) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        int last = list.isEmpty()?0:list.getLast();
        for (int i = last+1; i <= n; i++) {
            if(n - i >= k - list.size() - 1){
                list.add(i);
                back(list,n,k);
                list.removeLast();
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        visited = new boolean[nums.length];
        backPermute(nums,nums.length,new ArrayList<>());
        return result;
    }

    public static void backPermute(int[] nums,int n,List<Integer> cur) {
        if (n==0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur.add(nums[i]);
                backPermute(nums,n-1,cur);
                cur.removeLast();
                visited[i] = false;
            }
        }
    }
}
