package Leetcode.leet150.kadane;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println(maxSubarraySumCircular(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSumEndingHere = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSumEndingHere = Math.max(maxSumEndingHere + nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxSumEndingHere);
        }
        return maxSum;
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int maxSumEndingHere = nums[0];
        int minSumEndingHere = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSumEndingHere = Math.max(maxSumEndingHere + nums[i], nums[i]);
            minSumEndingHere = Math.min(minSumEndingHere + nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxSumEndingHere);
            minSum = Math.min(minSum, minSumEndingHere);
            sum += nums[i];
        }
        return maxSum<0?maxSum:Math.max(maxSum, sum - minSum);
    }
}
