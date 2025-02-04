class DiagonalWinStrategy implements WinStrategy {
    @Override
    public boolean checkWin(char[][] board, int size, String symbol) {
        char symbolChar = symbol.charAt(0);

        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbolChar) {
                win = false;
                break;
            }
        }
        if (win) return true;

        win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != symbolChar) {
                win = false;
                break;
            }
        }
        return win;
    }
}
