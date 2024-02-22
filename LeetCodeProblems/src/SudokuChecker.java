import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.*;

public class SudokuChecker {

    public boolean isValidSudoku(char[][] board) {
        Thread[] threads = new Thread[3];
        boolean[] results = new boolean[3];

        // Check rows
        threads[0] = new Thread(() -> results[0] = checkRows(board));
        threads[0].start();

        // Check columns
        threads[1] = new Thread(() -> results[1] = checkColumns(board));
        threads[1].start();

        // Check sub-grids
        threads[2] = new Thread(() -> results[2] = checkSubGrids(board));
        threads[2].start();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (boolean result : results) {
            if (!result) {
                return false;
            }
        }

        return true;
    }

    private boolean checkRows(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (rowCheck[num])
                        return false;
                    rowCheck[num] = true;
                }
            }
        }
        return true;
    }

    private boolean checkColumns(char[][] board) {
        for (int j = 0; j < 9; j++) {
            boolean[] colCheck = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (colCheck[num])
                        return false;
                    colCheck[num] = true;
                }
            }
        }
        return true;
    }

    private boolean checkSubGrids(char[][] board) {
        for (int block = 0; block < 9; block++) {
            boolean[] blockCheck = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        if (blockCheck[num])
                            return false;
                        blockCheck[num] = true;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void testValidSudoku() {
        char[][] validSudoku = {
                {'1', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assertTrue(isValidSudoku(validSudoku));
    }

    @Test
    public void testInvalidSudoku() {
        char[][] invalidSudoku = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assertTrue(isValidSudoku(invalidSudoku));
    }
}
