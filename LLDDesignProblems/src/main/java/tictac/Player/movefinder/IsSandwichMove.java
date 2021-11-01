package tictac.Player.movefinder;

import tictac.GameData;
import tictac.Move;

public class IsSandwichMove implements MoveFinder {
    MoveFinder moveFinder;

    @Override
    public void setNext(MoveFinder moveFinder) {
        this.moveFinder = moveFinder;
    }

    @Override
    public Move find(GameData gameData, char mySymbol, char otherSymbol) {
        if ((gameData.data[0][0] == otherSymbol && gameData.data[2][2] == otherSymbol) ||
                (gameData.data[0][2] == otherSymbol && gameData.data[2][0] == otherSymbol)) {
            if (gameData.data[0][1] == '-') {
                return new Move(0, 1, mySymbol);
            }
            if (gameData.data[1][0] == '-') {
                return new Move(1, 0, mySymbol);
            }
            if (gameData.data[1][2] == '-') {
                return new Move(1, 2, mySymbol);
            }
            if (gameData.data[2][1] == '-') {
                return new Move(2, 1, mySymbol);
            }
        }
        return moveFinder.find(gameData, mySymbol, otherSymbol);
    }
}
