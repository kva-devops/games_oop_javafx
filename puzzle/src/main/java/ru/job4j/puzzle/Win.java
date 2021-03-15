package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        int[] diagonalArr = extractDiagonal(board);
        for (int i = 0; i < board.length; i++) {
            if (diagonalArr[i] == 1 && (checkHorizontal(board, i) || checkVertical(board, i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    // extract diagonal
    public static int[] extractDiagonal(int[][] board) {
        int[] rsl = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            rsl[i] = board[i][i];
        }
        return rsl;
    }
    //check horizontal
    public static boolean checkHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    //check vertical
    public static boolean checkVertical(int[][] board, int col) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
