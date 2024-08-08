package Leetcode.leet150.graph;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.addAll(List.of(new Node[]{node2, node4}));
        node2.neighbors.addAll(List.of(new Node[]{node1, node3}));
        node3.neighbors.addAll(List.of(new Node[]{node2, node4}));
        node4.neighbors.addAll(List.of(new Node[]{node1, node3}));
        HashSet<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        Node node = cloneGraph(node1);
        q.offer(node);
        set.add(node);
        while (!q.isEmpty()) {
            node = q.poll();
            System.out.print(node.val + ":");
            for (Node n : node.neighbors) {
                if (!set.contains(n)) {
                    q.offer(n);
                    set.add(n);
                }
                System.out.print(n.val + " ");
            }
            System.out.println();
        }

    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private static boolean[][] visited;
    private static boolean surround;
    private static HashMap<Node, Node> hashMap;

    public static int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    visited[i][j] = true;
                    dfsVisit(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfsVisit(char[][] grid, int i, int j) {
        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == '1') {
            visited[i - 1][j] = true;
            dfsVisit(grid, i - 1, j);
        }
        if (i + 1 < grid.length && !visited[i + 1][j] && grid[i + 1][j] == '1') {
            visited[i + 1][j] = true;
            dfsVisit(grid, i + 1, j);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == '1') {
            visited[i][j - 1] = true;
            dfsVisit(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length && !visited[i][j + 1] && grid[i][j + 1] == '1') {
            visited[i][j + 1] = true;
            dfsVisit(grid, i, j + 1);
        }
    }

    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfsSolve(board, i, 0);
            dfsSolve(board, i, board[i].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfsSolve(board, 0, i);
            dfsSolve(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '0') {
                    board[i][j] = 'O';
                } else board[i][j] = 'X';
            }
        }
    }

    public static void dfsSolve(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if (board[i][j] == 'O') {
            board[i][j] = '0';
            dfsSolve(board, i - 1, j);
            dfsSolve(board, i + 1, j);
            dfsSolve(board, i, j - 1);
            dfsSolve(board, i, j + 1);
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        hashMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (!hashMap.containsKey(curr))
                hashMap.put(curr, new Node(curr.val));
            for (Node neighbor : curr.neighbors) {
                if (!hashMap.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    hashMap.put(neighbor, new Node(neighbor.val));
                }
                hashMap.get(curr).neighbors.add(hashMap.get(neighbor));
            }
        }
        return hashMap.get(node);
    }
}
