package tictac.Player;

import tictac.GameData;
import tictac.Move;
import tictac.Player.movefinder.MoveFinder;

public class ComputerPlayer implements Player {
    GameData gameData;
    MoveFinder moveFinder;
    char mySymbol;
    char otherSymbol;

    public ComputerPlayer(GameData gameData, MoveFinder moveFinder, char mySymbol, char otherSymbol) {
        this.gameData = gameData;
        this.moveFinder = moveFinder;
        this.mySymbol = mySymbol;
        this.otherSymbol = otherSymbol;
    }

    @Override
    public Move next() {
        System.out.println("It's Computer turn");
        return moveFinder.find(gameData, mySymbol, otherSymbol);
    }

    @Override
    public void declareWinner() {
        System.out.println("Computer has won");
    }
}
