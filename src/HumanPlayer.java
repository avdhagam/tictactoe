import java.util.Scanner;

class HumanPlayer implements Player {
    private final String symbol;
    private final Scanner scanner;

    public HumanPlayer(String symbol) {
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Move makeMove(char[][] board, int size) {
        while (true) {
            try {
                System.out.printf("Enter row (0-%d): ", size - 1);
                int row = scanner.nextInt();
                System.out.printf("Enter column (0-%d): ", size - 1);
                int col = scanner.nextInt();

                if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
                    return new Move(row, col);
                }
                System.out.println("Invalid move. Try again.");
            } catch (Exception e) {
                System.out.println("Please enter valid numbers.");
                scanner.nextLine();
            }
        }
    }
}
