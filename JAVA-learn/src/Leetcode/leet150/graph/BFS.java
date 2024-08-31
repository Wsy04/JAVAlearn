package Leetcode.leet150.graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        String s = "AAAACCCC";
        String t = "CCCCCCCC";
        String[] bank = {"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
        System.out.println(minMutation(s, t, bank));
    }

    private static Queue<Integer> queue;

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
        boolean[] visited = new boolean[n * n + 1];
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

    public static int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        HashSet<String> visited = new HashSet<>();
        if (!set.contains(endGene)) {
            return -1;
        }
        Queue<String> geneQueue = new LinkedList<>();
        char[] gene = {'A', 'C', 'G', 'T'};
        geneQueue.add(startGene);
        visited.add(startGene);
        int step = 1;
        while (!geneQueue.isEmpty()) {
            int size = geneQueue.size();
            for (int i0 = 0; i0 < size; i0++) {
                String cur = geneQueue.poll();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (cur.charAt(i) != gene[j]) {
                            StringBuilder sb = new StringBuilder(cur);
                            sb.setCharAt(i, gene[j]);
                            if(!visited.contains(sb.toString())&&set.contains(sb.toString())){
                                if(sb.toString().equals(endGene)) return step;
                                visited.add(sb.toString());
                                geneQueue.add(sb.toString());
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
