package tictac;

import tictac.Player.ComputerPlayer;
import tictac.Player.ConsolePlayer;
import tictac.Player.Player;
import tictac.Player.movefinder.MoveFactory;

import java.util.Scanner;

public class GameManager {

    public static void main(String[] args) {
        singlePlayerComputerStart();

    }

    public static void singlePlayerOtherStart() {
        Scanner sc = new Scanner(System.in);
        GameData gameData = new GameData();
        MoveFactory moveFactory = new MoveFactory();
        System.out.println("Please end player1 name");
        Player player1 = new ConsolePlayer(sc, sc.next(), 'O');
        Player player2 = new ComputerPlayer(gameData, moveFactory.getMoveFinder(), 'X', 'O');
        GameContext gameContext = new GameContext(player1, player2, gameData);
        gameContext.start();
    }

    public static void singlePlayerComputerStart() {
        Scanner sc = new Scanner(System.in);
        GameData gameData = new GameData();
        MoveFactory moveFactory = new MoveFactory();
        Player player1 = new ComputerPlayer(gameData, moveFactory.getMoveFinder(), 'O', 'X');
        System.out.println("Please end player2 name");
        Player player2 = new ConsolePlayer(sc, sc.next(), 'X');
        GameContext gameContext = new GameContext(player1, player2, gameData);
        gameContext.start();
    }

    public static void doublePlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please end player1 name");
        Player player1 = new ConsolePlayer(sc, sc.next(), 'O');
        System.out.println("Please end player2 name");
        Player player2 = new ConsolePlayer(sc, sc.next(), 'X');
        GameData gameData = new GameData();
        GameContext gameContext = new GameContext(player1, player2, gameData);
        gameContext.start();
    }

}
