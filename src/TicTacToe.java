import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TicTacToe {
    private final char[][] board;
    private final int size;
    private final List<Player> players = new ArrayList<>();
    private final List<WinStrategy> winStrategies = new ArrayList<>();
    private final List<GameObserver> observers = new ArrayList<>();
    private int currentPlayerIndex;
    private boolean isGameOver = false;

    public TicTacToe(int size) {
        this.size = size;
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], ' ');
        }
        winStrategies.add(new RowWinStrategy());
        winStrategies.add(new ColumnWinStrategy());
        winStrategies.add(new DiagonalWinStrategy());
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void makeMove(Player player, int row, int col) {
        board[row][col] = player.getSymbol().charAt(0);
        notifyObservers(player);
    }

    private void notifyObservers(Player currentPlayer) {
        for (GameObserver observer : observers) {
            observer.update(board, size, currentPlayer.getSymbol());
        }
    }

    private boolean checkWin(String symbol) {
        return winStrategies.stream().anyMatch(strategy -> strategy.checkWin(board, size, symbol));
    }

    private boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void play() {
        while (!isGameOver) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.printf("Player %s's turn (%s)\n", currentPlayerIndex + 1, currentPlayer.getSymbol());

            Move move = currentPlayer.makeMove(board, size);
            board[move.getRow()][move.getCol()] = currentPlayer.getSymbol().charAt(0);

            if (checkWin(currentPlayer.getSymbol())) {
                System.out.printf("Player %s wins!\n", currentPlayerIndex + 1);
                printBoard();
                isGameOver = true;
                return;
            }

            if (isBoardFull()) {
                System.out.println("It's a draw!");
                printBoard();
                isGameOver = true;
                return;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            printBoard();
        }
    }

    private void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] == ' ' ? "." : board[i][j]);
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < size - 1) System.out.println("-".repeat(size * 4 - 1));
        }
    }
}
