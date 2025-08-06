import java.util.Arrays;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sudoku(board, 0, 0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println();

        }

    }

    private static boolean sudoku(char[][] ar, int r, int c) {
        if (r == ar.length) return true;
        if (c == ar[0].length) return sudoku(ar, r + 1, 0);

        if (ar[r][c] != '.') {
            return sudoku(ar, r, c + 1);
        } else {
            for (int j = 1; j <= 9; j++) {
                char val = (char) (j + '0');
                if (isSafe(ar, r, c, val)) {
                    ar[r][c] = val;
                    if (sudoku(ar, r, c + 1)) {
                        return true;
                    }
                    ar[r][c] = '.';
                }
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] ar, int r, int c, int val) {
        for (int j = 0; j < 9; j++) {
            if (ar[r][j] == val || ar[j][c] == val) return false;
        }
        int mrow = r % 3;
        int mcol = c % 3;
        return Loop(ar, r, c, mrow, mcol, val);
    }

    private static boolean Loop(char[][] ar, int r, int c, int mrow, int mcol, int val) {
        for (int i = r - mrow; i < r - mrow + 3; i++) {
            for (int j = c - mcol; j < c - mcol + 3; j++) {
                if (ar[i][j] == val) return false;
            }
        }
        return true;
    }
}
