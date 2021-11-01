package tictac.Player.movefinder;

import tictac.GameData;
import tictac.Move;

public class OtherPlayerWinning implements MoveFinder {

    MoveFinder moveFinder;

    @Override
    public void setNext(MoveFinder moveFinder) {
        this.moveFinder = moveFinder;
    }

    @Override
    public Move find(GameData gameData, char symbol, char otherSymbol) {
        for (int i = 0; i < 3; i++) {
            int pos = 0, countEmpty = 0, countSymbol = 0;
            for (int j = 0; j < 3; j++) {
                if (gameData.data[i][j] == otherSymbol) {
                    countSymbol++;
                } else if (gameData.data[i][j] == '-') {
                    countEmpty++;
                    pos = j;
                }
            }
            if (countSymbol == 2 && countEmpty == 1) {
                return new Move(i, pos, symbol);
            }
        }

        for (int i = 0; i < 3; i++) {
            int pos = 0, countEmpty = 0, countSymbol = 0;
            for (int j = 0; j < 3; j++) {
                if (gameData.data[j][i] == otherSymbol) {
                    countSymbol++;
                } else if (gameData.data[j][i] == '-') {
                    countEmpty++;
                    pos = j;
                }
            }
            if (countSymbol == 2 && countEmpty == 1) {
                return new Move(pos, i, symbol);
            }
        }

        int pos = 0, countEmpty = 0, countSymbol = 0;
        for (int i = 0; i < 3; i++) {
            if (gameData.data[i][i] == otherSymbol) {
                countSymbol++;
            } else if (gameData.data[i][i] == '-') {
                countEmpty++;
                pos = i;
            }
        }
        if (countSymbol == 2 && countEmpty == 1) {
            return new Move(pos, pos, symbol);
        }
        pos = 0;
        countEmpty = 0;
        countSymbol = 0;
        for (int i = 0; i < 3; i++) {
            if (gameData.data[i][2 - i] == otherSymbol) {
                countSymbol++;
            } else if (gameData.data[i][2 - i] == '-') {
                countEmpty++;
                pos = i;
            }
        }
        if (countSymbol == 2 && countEmpty == 1) {
            return new Move(pos, 2 - pos, symbol);
        }
        return moveFinder.find(gameData, symbol, otherSymbol);
    }
}
