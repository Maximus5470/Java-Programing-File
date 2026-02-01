package DAAinternal;

import java.util.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; // queens[i] = column position of queen in row i
        backtrack(0, n, queens, result);
        return result;
    }

    private static void backtrack(int row, int n, int[] queens, List<List<String>> result) {
        if (row == n) {
            result.add(createBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col;
                backtrack(row + 1, n, queens, result);
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> createBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (queens[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            board.add(sb.toString());
        }
        return board;
    }

    public static void printSolution(List<String> board) {
        for (String row : board) {
            System.out.println(row);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);

        System.out.println("Number of solutions for " + n + "-Queens: " + solutions.size());
        System.out.println("\nAll solutions:");

        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            printSolution(solutions.get(i));
        }
    }
}