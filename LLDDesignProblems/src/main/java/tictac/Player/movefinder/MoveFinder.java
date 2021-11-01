package tictac.Player.movefinder;

import tictac.GameData;
import tictac.Move;

public interface MoveFinder {
    void setNext(MoveFinder moveFinder);
    Move find(GameData gameData, char mySymbol, char otherSymbol);
}
