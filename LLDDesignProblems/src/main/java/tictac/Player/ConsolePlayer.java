package tictac.Player;

import tictac.Move;

import java.util.Scanner;

public class ConsolePlayer implements Player {
    Scanner sc;
    String playerName;
    char symbol;

    public ConsolePlayer(Scanner sc, String playerName, char symbol) {
        this.sc = sc;
        this.playerName = playerName;
        this.symbol = symbol;
    }

    @Override
    public Move next() {
        System.out.println("It's " + playerName + " turn");
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new Move(x, y, symbol);
    }

    @Override
    public void declareWinner() {
        System.out.println(playerName + " has won the game.");
    }
}
