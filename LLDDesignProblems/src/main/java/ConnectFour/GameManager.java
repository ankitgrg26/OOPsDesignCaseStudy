package ConnectFour;

import java.util.Scanner;

public class GameManager {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        Scanner sc = new Scanner(System.in);
        Player player1 = new ConsolePlayer(sc, 'O', "Ankit");
        Player player2 = new ConsolePlayer(sc, 'X', "Akshita");

        GameContext context = new GameContext(gameBoard, player1, player2);
        context.start();
    }
}
