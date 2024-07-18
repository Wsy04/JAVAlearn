package Leetcode.leet150.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
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

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
}
