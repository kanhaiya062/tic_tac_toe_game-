import java.util.Scanner;

public class tic_tac{
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        char currentPlayer = 'X';
        boolean isGameInProgress = true;
        int moves = 0;
        
        while (isGameInProgress) {
            printBoard(board);
            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
            
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            
            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;
                moves++;
                
                if (isWin(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    isGameInProgress = false;
                } else if (moves == 9) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    isGameInProgress = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
    }

    private static boolean isWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }
}
