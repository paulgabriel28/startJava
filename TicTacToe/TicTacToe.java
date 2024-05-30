public class TicTacToe {
    private final char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
            return false;
        }

        board[row][col] = currentPlayer;
        if (hasWon() == false) {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        return true;
    }

    public boolean hasWon() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }

        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        else if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        
        while (game.hasWon() == false && game.isBoardFull() == false) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + ": ");
            
            System.out.print("Introdu linia [1 - 3]: ");
            int row = Integer.parseInt(System.console().readLine());
            row--;

            System.out.print("Introdu coloana [1 - 3]: ");
            int col = Integer.parseInt(System.console().readLine());
            col--;

            if (game.makeMove(row, col) == false) {
                System.err.println("Valoare invalida.");
            }
        }

        if (game.hasWon() == true) {
            System.err.println("Player-ul " + game.currentPlayer + " a castigat!");
        }
        else {
            System.err.println("It's a draw!");
        }

        game.printBoard();

    }
}