package Leetcode.leet150.matrix;

public class Solution {
    public static void main(String[] args) {


    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (rows[i][(int) (c - '1')] != 0) {
                        return false;
                    }
                    if (cols[j][(int) (c - '1')] != 0) {
                        return false;
                    }
                    if (boxes[(i / 3) * 3 + (j / 3)][(int) (c - '1')] != 0) {
                        return false;
                    }
                    rows[i][(int) (c - '1')]++;
                    cols[j][(int) (c - '1')]++;
                    boxes[(i / 3) * 3 + (j / 3)][(int) (c - '1')]++;
                }
            }
        }

        return true;
    }
}
