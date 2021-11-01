package tictac;

import tictac.Player.Player;

public class GameContext {
    Player player1;
    Player player2;
    GameData gameData;

    public GameContext(Player player1, Player player2, GameData gameData) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameData = gameData;
    }

    public void start() {
        while (!gameData.isEnd()) {
            gameData.print();
            if (performMove(player1)) {
                return;
            }
            gameData.print();
            if (performMove(player2)) {
                return;
            }
        }
        System.out.println("Game has tied");
    }

    private boolean performMove(Player player) {
        while (true) {
            try {
                Move move = player.next();
                gameData.fill(move);
                if (gameData.isWinner(move)) {
                    player.declareWinner();
                    return true;
                }
                return false;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
