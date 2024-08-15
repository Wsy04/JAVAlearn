package Leetcode.leet150.graph;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

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
    private static List<List<Integer>> graph;
    private static int[] visit;
    private static boolean valid;
    private static List<Integer> res;
    private static double ans;
    private static HashMap<String,node1> map;

    public static class node1{
        public String name;
        public List<edge> neighbors;
        public node1(){
            this.name = "";
            this.neighbors = new ArrayList<>();
        }
        public node1(String name){
            this.name = name;
            this.neighbors = new ArrayList<>();
        }
        public node1(String name, List<edge> neighbors) {
            this.name = name;
            this.neighbors = neighbors;
        }
    }
    public static class edge{
        public String name;
        public double val;
        public edge(String name, double val) {
            this.name = name;
            this.val = val;
        }
    }
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

    public static Node cloneGraph(Node node1) {
        if (node1 == null) return null;
        hashMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node1);
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
        return hashMap.get(node1);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        valid = true;
        visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                dfsCanFinish(i);
            }
        }
        return valid;
    }

    public static void dfsCanFinish(int u) {
        visit[u] = 1;
        for (int v : graph.get(u)) {
            if (visit[v] == 0) {
                dfsCanFinish(v);
                if (!valid) return;
            } else if (visit[v] == 1) {
                valid = false;
                return;
            }
        }
        visit[u] = 2;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        valid = true;
        visit = new int[numCourses];
        res = new ArrayList<>();
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                dfsFind(i);
            }
        }
        if (!valid) return null;
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void dfsFind(int u) {
        visit[u] = 1;
        for (int v : graph.get(u)) {
            if (visit[v] == 0) {
                dfsFind(v);
                if (!valid) return;
            } else if (visit[v] == 1) {
                valid = false;
                return;
            }
        }
        visit[u] = 2;
        res.add(u);
    }

    private static HashMap<String,Integer> mark;
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        int index = 0;
        int n = equations.size();
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name1 = equations.get(i).getFirst();
            String name2 = equations.get(i).getLast();
            node1 n1 = map.getOrDefault(name1,new node1(name1));
            n1.neighbors.add(new edge(name2,values[i]));
            map.put(name1,n1);
            node1 n2 = map.getOrDefault(name2,new node1(name2));
            n2.neighbors.add(new edge(name1,1.0/values[i]));
            map.put(name2,n2);
        }
        for (List<String> query : queries) {
            ans = 1.0;
            mark = new HashMap<>();
            mark.put(query.getFirst(),1);
            mark.put(query.getLast(),1);
            dfsCalcEquation(query.getFirst(),query.getLast());
            if(mark.getOrDefault(query.getLast(),0)!=2){
                ans = -1.0;
            }
            result[index++] = ans;
        }
        return result;
    }

    public static void dfsCalcEquation(String s1,String s2){
        if(!map.containsKey(s1)||!map.containsKey(s2)) return;
        if(s1.equals(s2)){
            ans = 1.0;
            mark.put(s2,2);
            return;
        }

        node1 n1 = map.get(s1);
        node1 n2 = map.get(s2);
        for (edge neighbor : n1.neighbors) {
            if(mark.getOrDefault(s2,0)==2){
                return;
            }
            else if(neighbor.name.equals(n2.name)){
                mark.put(s2,2);
                ans*=neighbor.val;
                return;
            }
            else if(mark.getOrDefault(neighbor.name,0)==0){
                mark.put(neighbor.name,1);
                ans*=neighbor.val;
                dfsCalcEquation(neighbor.name,s2);
                if(mark.getOrDefault(s2,0)!=2)
                    ans/=neighbor.val;
            }
        }
    }
}
