package Backtracking;

public class advance {
    private static void nQueen(char[][] board, int row ){
        int n = board.length;
        // BASE CASE 
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println("-------------");
            return;
        }

        // KAAM
        for (int j = 0; j < board.length; j++) {//To check wheather Q is in row ?
            if (isSafe(board, row, j)) {
                board [row][j] = 'Q';
                nQueen(board, row+1);
                board [row][j] = 'X'; //Backtracking
            }
            
        }

        
    }

    private static boolean isSafe(char[][] board, int row, int col){
        int n = board.length;
        // Check row
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        // Check col
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check North East
        int i = row, j = col;
        while (i>=0 && j<n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--; j++;
        }
        // Check South East
        i = row; j = col;
        while (i<n && j<n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++; j++;
        }
        // Check North West
        i = row; j = col;
        while (i>=0 && j>=0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--; j--;
        }
        // Check South West 
        i = row; j = col;
        while (i<n && j>=0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++; j--;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 4 ; //Size of chess board 
        char[][] board = new char[n][n]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nQueen(board,0); // 0 - starting row
    }
}
