package ConnectFour;

public class GameBoard {
    char[][] data;
    int[] pos;

    public GameBoard() {
        data = new char[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                data[i][j] = '-';
            }
        }
        pos = new int[7];
    }

    public boolean fill(Move move) {
        int h = pos[move.index];
        data[h][move.index] = move.color;
        pos[move.index]++;
        return isWinner(move);
    }

    public void print() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isWinner(Move move) {
        int y = move.index;
        int x = pos[y] - 1;
        int prev = 0;
        for (int i = 0; i < 6; i++) {
            if (data[i][y] != move.color) {
                prev = 0;
            } else {
                prev = prev + 1;
            }

            if (prev == 4) {
                return true;
            }
        }

        for (int i = 0; i < 7; i++) {
            if (data[x][i] != move.color) {
                prev = 0;
            } else {
                prev = prev + 1;
            }

            if (prev == 4) {
                return true;
            }
        }

        int xMin = x - Math.min(x, y);
        int yMin = y - Math.min(x, y);
        prev = 0;
        while (xMin < 6 && yMin < 7) {
            if (data[xMin][yMin] != move.color) {
                prev = 0;
            } else {
                prev = prev + 1;
            }
            xMin++;
            yMin++;
            if (prev == 4) {
                return true;
            }
        }
        xMin = x - Math.min(x, 7 - y);
        int yMax = y + Math.min(x, 7 - y);

        while (xMin < 6 && yMax >= 0) {
            if (data[xMin][yMax] != move.color) {
                prev = 0;
            } else {
                prev = prev + 1;
            }
            xMin++;
            yMax--;
            if (prev == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isFill() {
        for (int i = 0; i < 7; i++) {
            if (pos[i] < 6) {
                return false;
            }
        }
        return true;
    }

}
