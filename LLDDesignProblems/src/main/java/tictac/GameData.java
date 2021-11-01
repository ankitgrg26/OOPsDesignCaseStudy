package tictac;

public class GameData {
    public char[][] data;

    public GameData() {
        data = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = '-';
            }
        }
    }

    public void fill(Move move) {

        if (move.x < 0 || move.x > 2 || move.y < 0 || move.y > 2) {
            throw new RuntimeException("Invalid position exception");
        }
        if (data[move.x][move.y] != '-') {
            throw new RuntimeException("Invalid position exception");
        }
        data[move.x][move.y] = move.c;
    }

    public boolean isWinner(Move move) {
        return (data[move.x][0] == move.c && data[move.x][1] == move.c && data[move.x][2] == move.c) ||
                (data[0][move.y] == move.c && data[1][move.y] == move.c && data[2][move.y] == move.c) ||
                (move.x == 1 && move.y == 1 && data[0][0] == move.c && data[2][2] == move.c) ||
                (move.x == 1 && move.y == 1 && data[0][2] == move.c && data[2][0] == move.c);

    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isEnd() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
