class RowWinStrategy implements WinStrategy {
    @Override
    public boolean checkWin(char[][] board, int size, String symbol) {
        char symbolChar = symbol.charAt(0);
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != symbolChar) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }
}
