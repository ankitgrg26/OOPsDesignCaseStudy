package tictac.Player.movefinder;

import tictac.GameData;
import tictac.Move;

public class PickCorner implements MoveFinder {
    MoveFinder moveFinder;

    @Override
    public void setNext(MoveFinder moveFinder) {
        this.moveFinder = moveFinder;
    }

    @Override
    public Move find(GameData gameData, char mySymbol, char otherSymbol) {
        if (gameData.data[0][0] == '-') {
            return new Move(0, 0, mySymbol);
        }
        if (gameData.data[0][2] == '-') {
            return new Move(0, 2, mySymbol);
        }
        if (gameData.data[2][0] == '-') {
            return new Move(2, 0, mySymbol);
        }
        if (gameData.data[2][2] == '-') {
            return new Move(2, 2, mySymbol);
        }
        return moveFinder.find(gameData, mySymbol, otherSymbol);
    }
}
