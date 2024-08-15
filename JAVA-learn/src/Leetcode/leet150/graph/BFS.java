package Leetcode.leet150.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
//        int[][] board = {{-1,-1},{-1,1}};
        int ans = snakesAndLadders(board);
        System.out.println(ans);
    }

    private static Queue<Integer> queue;
    private static boolean[] visited;

    public static int getId(int i,int j,int n){
        int row = n - i;//实际的第row行
        int cur = (row - 1) * n + 1;//计算当前的编号
        if (row % 2 == 0) {
            cur += n - j;
        } else cur += j + 1;
        return cur;
    }
    public static int[] getIndex(int n, int id) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }

    public static int snakesAndLadders(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        int n = board.length;
        visited = new boolean[n*n+1];
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int nextId = cur[0]+i;
                if(nextId>n*n) break;;
                int[] next = getIndex(n,nextId);
                if (board[next[0]][next[1]] != -1) {
                    nextId = board[next[0]][next[1]];
                }
                if (nextId == n*n) {
                    return cur[1]+1;
                }
                if (!visited[nextId]) {
                    visited[nextId] = true;
                    queue.offer(new int[]{nextId,cur[1]+1});
                }
            }
        }

        return -1;
    }
}
