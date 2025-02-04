import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        int size = scanner.nextInt();

        System.out.printf("Enter the number of players (2 to %d): ", size - 1);
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        if (numPlayers < 2 || numPlayers >= size) {
            System.out.println("Invalid number of players");
            return;
        }

        TicTacToe game = new TicTacToe(size);
        String[] symbols = {"X", "O", "A", "B", "C", "D", "E", "F", "G"};

        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("Player %d - Enter type (human/bot): ", i + 1);
            String playerType = scanner.nextLine();
            Player player = PlayerFactory.createPlayer(playerType, symbols[i]);
            game.addPlayer(player);
        }

        GameStateObserver observer = new GameStateObserver();
        game.addObserver(observer);

        game.play();
        scanner.close();
    }
}
