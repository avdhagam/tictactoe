class PlayerFactory {
    public static Player createPlayer(String playerType, String symbol) {
        return switch (playerType.toLowerCase()) {
            case "human" -> new HumanPlayer(symbol);
            case "bot" -> new BotPlayer(symbol);
            default -> throw new IllegalArgumentException("Invalid player type");
        };
    }
}
