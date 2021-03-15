package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        if (checkHorizontal(board) || checkVertical(board)) {
            rsl = true;
        }
        return rsl;
    }

    //check horizontal
    public static boolean checkHorizontal(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            int counter = 0;
            if (board[i][i] == 1) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != 1) {
                        break;
                    } else {
                        counter++;
                    }
                }
            }
            if (counter == board[0].length) {
               result = true;
            }
        }
        return result;
    }

    //check vertical
    public static boolean checkVertical(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            int counter = 0;
            if (board[i][i] == 1) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[j][i] != 1) {
                        break;
                    } else {
                        counter++;
                    }
                }
            }
            if (counter == board[0].length) {
                result = true;
            }
        }
        return result;
    }
}
