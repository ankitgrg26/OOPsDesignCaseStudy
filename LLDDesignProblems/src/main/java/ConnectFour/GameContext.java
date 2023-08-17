package ConnectFour;

public class GameContext {
    public GameBoard gameBoard;
    public Player player1;
    public Player player2;

    public GameContext(GameBoard gameBoard, Player player1, Player player2) {
        this.gameBoard = gameBoard;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {

        while (!gameBoard.isFill()) {
            gameBoard.print();
            Move next = player1.fill();
            if (gameBoard.fill(next)) {
                gameBoard.print();
                player1.declareWinner();
                return;
            }
            gameBoard.print();
            next = player2.fill();
            if (gameBoard.fill(next)) {
                gameBoard.print();
                player2.declareWinner();
                return;
            }
        }
    }
}
