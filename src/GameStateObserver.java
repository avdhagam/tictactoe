class GameStateObserver implements GameObserver {
    @Override
    public void update(char[][] board, int size, String currentPlayerSymbol) {
        if (checkWin(board, size, currentPlayerSymbol)) {
            System.out.printf("Player with symbol '%s' wins!\n", currentPlayerSymbol);
        } else if (isBoardFull(board, size)) {
            System.out.println("It's a draw!");
        }
    }

    private boolean checkWin(char[][] board, int size, String symbol) {
        WinStrategy[] strategies = {new RowWinStrategy(), new ColumnWinStrategy(), new DiagonalWinStrategy()};
        for (WinStrategy strategy : strategies) {
            if (strategy.checkWin(board, size, symbol)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull(char[][] board, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
