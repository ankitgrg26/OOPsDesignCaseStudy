package tictac.Player.movefinder;

import tictac.GameData;

public class MoveFactory {
    public MoveFinder getMoveFinder() {
        MoveFinder centreMove = new CentreMove();
        MoveFinder playerWinning = new PlayerWinning();
        MoveFinder otherPlayerWinning = new OtherPlayerWinning();
        MoveFinder randomMove = new RandomMove();
        MoveFinder pickCorner = new PickCorner();
        MoveFinder sandwich = new IsSandwichMove();
        playerWinning.setNext(otherPlayerWinning);
        otherPlayerWinning.setNext(centreMove);
        centreMove.setNext(sandwich);
        sandwich.setNext(pickCorner);
        pickCorner.setNext(randomMove);
        return playerWinning;
    }
}
