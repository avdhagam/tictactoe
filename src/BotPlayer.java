import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BotPlayer implements Player {
    private final String symbol;
    private final Random random;

    public BotPlayer(String symbol) {
        this.symbol = symbol;
        this.random = new Random();
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Move makeMove(char[][] board, int size) {
        List<Move> emptyCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    emptyCells.add(new Move(i, j));
                }
            }
        }
        return emptyCells.get(random.nextInt(emptyCells.size()));
    }
}
