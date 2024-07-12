package Leetcode.leet150.doublePointer;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        if (s.length() > t.length()) return false;
        while (i < s.length() && j < t.length()) {
            while (j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            if (j == t.length()) {
                return false;
            }
            i++;
            j++;
        }
        return i == s.length();
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            }
        }
        return ans;
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i < j) {
            int min = Math.min(height[i], height[j]);
            ans = Math.max(ans, min * (j - i));
            while (height[j] <= min && i < j) {
                j--;
            }
            while (height[i] <= min && i < j) {
                i++;
            }
        }
        return ans;
    }
}
