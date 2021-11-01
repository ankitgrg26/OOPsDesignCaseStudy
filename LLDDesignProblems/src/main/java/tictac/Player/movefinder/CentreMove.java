package tictac.Player.movefinder;

import tictac.GameData;
import tictac.Move;
import tictac.Player.movefinder.MoveFinder;

public class CentreMove implements MoveFinder {
    MoveFinder moveFinder;

    @Override
    public void setNext(MoveFinder moveFinder) {
        this.moveFinder = moveFinder;
    }

    @Override
    public Move find(GameData gameData, char symbol, char otherSymbol) {
        if (gameData.data[1][1] == '-') {
            return new Move(1, 1, symbol);
        }
        return moveFinder.find(gameData, symbol, otherSymbol);
    }
}
