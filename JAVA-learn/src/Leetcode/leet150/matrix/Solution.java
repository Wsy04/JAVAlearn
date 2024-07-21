package Leetcode.leet150.matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        gameOfLife(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
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

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        int rowStart = 0, colStart = 0;
        int count = (rowEnd + 1) * (colEnd + 1);
        while (count > 0) {
            for (int j = colStart; j <= colEnd; j++) {
                list.add(matrix[rowStart][j]);
                count--;
            }
            if (count == 0) {
                break;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
                count--;
            }
            if (count == 0) {
                break;
            }
            colEnd--;
            for (int j = colEnd; j >= colStart; j--) {
                list.add(matrix[rowEnd][j]);
                count--;
            }
            if (count == 0) {
                break;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                list.add(matrix[i][colStart]);
                count--;
            }
            colStart++;
        }
        return list;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                rotateBlock(matrix, i, j);
            }
        }
        if (n % 2 == 1) {
            for (int j = 0; j < n / 2; j++) {
                rotateBlock(matrix, n / 2, j);
            }
        }
    }

    public static void rotateBlock(int[][] matrix, int i, int j) {
        int n = matrix.length;
        int temp = matrix[i][j];//n = 4//[0,1],[2,0],[3,2],[1,3]
        matrix[i][j] = matrix[n - 1 - j][i];
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
        matrix[j][n - 1 - i] = temp;
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (rows[i] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            if (cols[j] == 1) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void gameOfLife(int[][] board) {
        //3:live to die
        //2:die to live
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int num = count(board, i, j);
                if (board[i][j] % 2 == 0 && num == 3) {
                    board[i][j] = 2;
                }
                else if (board[i][j] % 2 == 1) {
                    if (num <= 1 || num > 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int count(int[][] matrix, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        int startI = Math.max(0, i - 1), startJ = Math.max(0, j - 1);
        int endI = Math.min(i + 1, m - 1), endJ = Math.min(j + 1, n - 1);
        int ans = 0;
        for (int ii = startI; ii <= endI; ii++) {
            for (int jj = startJ; jj <= endJ; jj++) {
                if (matrix[ii][jj] % 2 == 1) {
                    ans++;
                }
            }
        }
        ans -= matrix[i][j] % 2;
        return ans;
    }
}
