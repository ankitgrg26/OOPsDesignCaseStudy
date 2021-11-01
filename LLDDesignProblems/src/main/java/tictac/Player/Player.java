package tictac.Player;

import tictac.Move;

public interface Player {

     Move next();

    void declareWinner();
}
