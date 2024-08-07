package Leetcode.leet150.graph;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','1','0'},
                {'1','1','0','1','0'},
                {'0','0','1','0','0'},
                {'0','0','0','0','0'}
        };
        int res = numIslands(grid);
        System.out.println(res);
    }
    private static boolean[][] visited;
    public static int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]&&grid[i][j] == '1') {
                    count++;
                    visited[i][j] = true;
                    dfsVisit(grid,i,j);
                }
            }
        }
        return count;
    }
    public static void dfsVisit(char[][] grid,int i,int j) {
        if(i-1>=0&&!visited[i-1][j]&&grid[i-1][j]=='1') {visited[i-1][j]=true;dfsVisit(grid,i-1,j);}
        if(i+1<grid.length&&!visited[i+1][j]&&grid[i+1][j]=='1') {visited[i+1][j]=true;dfsVisit(grid,i+1,j);}
        if(j-1>=0&&!visited[i][j-1]&&grid[i][j-1]=='1') {visited[i][j-1]=true;dfsVisit(grid,i,j-1);}
        if(j+1<grid[0].length&&!visited[i][j+1]&&grid[i][j+1]=='1') {visited[i][j+1]=true;dfsVisit(grid,i,j+1);}
    }
}
