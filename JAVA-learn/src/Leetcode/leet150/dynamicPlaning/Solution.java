package Leetcode.leet150.dynamicPlaning;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(rob(arr));
    }

    public static int climbStairs(int n) {
        //dp[i]表示i级阶梯的走法
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int rob(int[] nums) {
        //dp[i][1]表示打劫第i家,dp[i][0]表示不打劫第i家的最大收入
        int[][] dp = new int[nums.length][2];
        int n = nums.length;
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[0];
        dp[1][1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0]+nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
