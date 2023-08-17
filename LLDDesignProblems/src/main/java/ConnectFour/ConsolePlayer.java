package ConnectFour;

import java.util.Scanner;

public class ConsolePlayer implements Player {
    Scanner sc;
    char symbol;
    String name;

    public ConsolePlayer(Scanner sc, char symbol, String name) {
        this.sc = sc;
        this.symbol = symbol;
        this.name = name;
    }

    @Override
    public Move fill() {
        System.out.println("It's " + name + " turn.");
        int column = sc.nextInt();
        return new Move(column, symbol);
    }

    @Override
    public void declareWinner() {
        System.out.println("Player " + name + " has won.");
    }
}
