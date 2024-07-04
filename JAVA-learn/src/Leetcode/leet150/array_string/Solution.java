package Leetcode.leet150.array_string;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,4,5,6,7};
//        int[] nums2 = {2,5,6};
//        int m = 0;
//        int n = 3;
//        String s = "MCMXCIV";
//        System.out.println(romanToInt(s));
//        merge(nums1,m,nums2,n);
//        for (int j : nums1) {
//            System.out.print(j + " ");
//        }
//        System.out.println(removeElement(nums1,m));
//        System.out.println(removeDuplicates2(nums1));
//        System.out.println(majorityElement(nums1));
        rotate(nums1,3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1,j = n-1;
        while (i>=0&&j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[i+j+1] = nums1[i];
                i--;
            }
            else {
                nums1[i+j+1] = nums2[j];
                j--;
            }
        }
        while (j>=0) nums1[j] = nums2[j--];
    }
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public static int removeDuplicates(int[] nums) {
        int k =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=nums[k]){
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }
    public static int romanToInt(String s) {
        int res = 0;
        int curInt;
        int preInt = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            curInt = getValue(s.charAt(i));
            if(curInt>preInt){
                res-=preInt;
            }
            else
                res+=preInt;
            preInt = curInt;
        }
        res+=preInt;
        return res;


    }
    private static int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
    public static int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if(len<2) return len;
        int k = 2;
        int i = 2;
        while (i<len){
            if(nums[i]!=nums[k-2]){
                nums[k++] = nums[i];
            }
            i++;
        }
        return k;
    }
    public static int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 0;
        for (int num : nums) {
            if (cur == num) {
                count++;
            }
            else if(count==0){
                cur = num;
            }
            else count--;
        }
        return cur;
    }
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k%=len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static void reverse(int[] nums,int begin,int end){
        while (begin<end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            end--;
            begin++;
        }
    }
}
