package Leetcode.leet150.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{5,6},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        intervals = insert(intervals,newInterval);
        for (int[] interval : intervals) {
            System.out.print("["+interval[0] + "," + interval[1]+"]");
            System.out.println();
        }
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i==nums.length-1||nums[i]!=nums[i+1]-1){
                StringBuilder sb = new StringBuilder();
                sb.append(nums[start]);
                if(i!=start){
                    sb.append("->");
                    sb.append(nums[i]);
                }
                res.add(sb.toString());
                start = i+1;
            }
        }
        return res;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i<intervals.length&&intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        int start = i==intervals.length?newInterval[0]:Math.min(intervals[i][0],newInterval[0]);
        int end = newInterval[1];
        while (i<intervals.length&&intervals[i][0]<=newInterval[1]){
            end = Math.max(end,intervals[i][1]);
            i++;
        }
        res.add(new int[]{start,end});
        while (i<intervals.length){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(o1,o2)->Integer.compare(o1[1],o2[1]));
        int ans = 1;
        int last = points[0][1];
        for (int[] point : points) {
            if(last<point[0]){
                ans++;
                last = point[1];
            }
        }
        return ans;
    }
}
