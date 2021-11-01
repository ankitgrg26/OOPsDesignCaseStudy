package tictac.Player.movefinder;

import tictac.GameData;
import tictac.Move;

public class RandomMove implements MoveFinder {

    MoveFinder moveFinder;

    @Override
    public void setNext(MoveFinder moveFinder) {
        this.moveFinder = moveFinder;
    }

    @Override
    public Move find(GameData gameData, char symbol, char otherSymbol) {
        if (gameData.isEnd()) {
            return null;
        }
        while (true) {
            int rand = (int) (Math.random() * 9.0);
            int x = rand / 3;
            int y = rand % 3;
            if (gameData.data[x][y] == '-') {
                return new Move(x, y, symbol);
            }
        }
    }
}
